package com.weather.chase.data.remote

import com.squareup.moshi.Json

/**
 * Created by peterx.theja on 2023-04-05.
 */
data class Weather(
    @field:Json(name = "id") val weatherId: Int,
    @field:Json(name = "main") val mainDesc: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "icon") val icon: String
)

data class Wind(
    @field:Json(name = "speed") val windSpeed: Double,
    @field:Json(name = "deg") val deg: Double,
    @field:Json(name = "gust") val gust: Double,
)
