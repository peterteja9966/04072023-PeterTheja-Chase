package com.weather.chase.data.remote

import com.squareup.moshi.Json

/**
 * Created by peterx.theja on 2023-04-05.
 */

data class WeatherData(
    @field:Json(name = "main")
    val weatherData: WeatherMetaData?,
    @field:Json(name = "weather")
    val mainWeather: List<Weather>?,
    @field:Json(name = "wind")
    val wind: Wind?
)
