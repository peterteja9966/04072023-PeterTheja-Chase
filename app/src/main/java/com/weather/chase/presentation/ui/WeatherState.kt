package com.weather.chase.presentation.ui

import com.weather.chase.data.mappers.WeatherUIModel
import com.weather.chase.domain.repository.local.LocationDao

/**
 * Created by peterx.theja on 2023-04-05.
 */
data class WeatherState(
    val weatherInfo: WeatherUIModel? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val currentCity: LocationDao? = null,
    val initialLoad: Boolean = false
)
