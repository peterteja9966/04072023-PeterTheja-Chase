package com.weather.chase.data.remote

import com.squareup.moshi.Json

/**
 * Created by peterx.theja on 2023-04-05.
 */
data class WeatherMetaData(
    @field:Json(name = "temp") val temperature: Double,
    @field:Json(name = "weather_code") val weatherCode: Double,
    @field:Json(name = "feels_like") val feelsLike: Double,
    @field:Json(name = "humidity") val humidity: Double,
)
