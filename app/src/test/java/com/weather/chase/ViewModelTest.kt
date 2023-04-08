/*
package com.weather.chase

import com.weather.chase.data.mappers.WeatherUIModel
import com.weather.chase.domain.location.LocationTracker
import com.weather.chase.domain.repository.remote.WeatherRepository
import com.weather.chase.presentation.ui.WeatherState
import com.weather.chase.presentation.viewmodels.WeatherrViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

*/
/**
 * Created by peterx.theja on 2023-04-07.
 *//*


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ViewModelTest {

    // WeatherRepository Mock
    private val repository = mock(WeatherRepository::class.java)
    private val locationTracker = mock(LocationTracker::class.java)

    // Create an instance of the ViewModel to be tested
    //private val viewModel = WeatherrViewModel(repository, locationTracker)

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `test for expected result from getWeather function`() = runBlocking {
        val UIModel = WeatherUIModel(
            temperature = "23",
            icon = "https://openweathermap.org/img/wn/10d@2x.png",
            windSpeed = "40",
            description = "cloudy",
            humidity = "23"
        )

        val expectedResult = WeatherState(
            UIModel, error = ""
        )
        //repository.getWeatherData()
        `when`(viewModel.loadWeatherInfo())
    }
}*/
