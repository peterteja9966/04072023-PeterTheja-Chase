package com.weather.chase.presentation.ui

/**
 * Created by peterx.theja on 2023-04-07.
 */
sealed class WeatherUIEvent {
    data class CitySearchClicked(val city: String) : WeatherUIEvent()
    object InitialLoad : WeatherUIEvent()
}