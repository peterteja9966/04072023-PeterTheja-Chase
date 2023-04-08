package com.weather.chase.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.chase.data.remote.WeatherReq
import com.weather.chase.domain.location.LocationTracker
import com.weather.chase.domain.repository.local.DatastoreRepository
import com.weather.chase.domain.repository.local.LocationDao
import com.weather.chase.domain.repository.local.LocationRepository
import com.weather.chase.domain.repository.remote.WeatherRepository
import com.weather.chase.domain.util.Constants
import com.weather.chase.domain.util.Resource
import com.weather.chase.presentation.ui.WeatherState
import com.weather.chase.presentation.ui.WeatherUIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by peterx.theja on 2023-04-06.
 */
@HiltViewModel
class WeatherrViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker,
    private val location: LocationRepository,
    private val dataStore: DatastoreRepository
) : ViewModel() {
    var state by mutableStateOf(WeatherState())
        private set

    init {
        state = state.copy(
            initialLoad = true
        )
    }

    fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let {
                if (state.initialLoad) {
                    if (!dataStore.getLat(Constants.LOC_LAT).isNullOrBlank()) {
                        state = state.copy(
                            currentCity = LocationDao(
                                lat = dataStore.getLat(Constants.LOC_LAT).toString(),
                                long = dataStore.getLong(Constants.LOC_LONG).toString()
                            )
                        )
                        state = state.copy(
                            initialLoad = false
                        )
                    } else {
                        state = state.copy(
                            currentCity = LocationDao(
                                lat = it.latitude.toString(),
                                long = it.longitude.toString()
                            )
                        )
                        state = state.copy(
                            initialLoad = false
                        )
                    }
                }
                when (val result = repository.getWeatherData(
                    WeatherReq(
                        state.currentCity?.lat,
                        state.currentCity?.long
                    )
                )) {
                    is Resource.Success -> {
                        state = state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Couldn't retrieve location.grant permission and enable GPS."
                )
            }
        }
    }

    fun onEvent(event: WeatherUIEvent) {
        when (event) {
            is WeatherUIEvent.CitySearchClicked -> {
                val dao: LocationDao =
                    location.getLocation(event.city, con = locationTracker.getContext())
                state = state.copy(
                    currentCity = dao
                )
                loadWeatherInfo()
                saveData(dao)
            }
            else -> {}
        }
    }

    private fun saveData(dao: LocationDao) {
        dataStore.putLat(Constants.LOC_LAT, dao.lat)
        dataStore.putLong(Constants.LOC_LONG, dao.long)
    }
}