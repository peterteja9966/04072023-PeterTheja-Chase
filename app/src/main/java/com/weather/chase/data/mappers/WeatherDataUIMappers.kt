package com.weather.chase.data.mappers

import com.weather.chase.data.remote.WeatherData
import com.weather.chase.domain.util.Constants
import kotlin.math.roundToInt

/**
 * Created by peterx.theja on 2023-04-06.
 */

fun WeatherData.toUIModels(): WeatherUIModel {
    return WeatherUIModel(
        temperature = weatherData?.temperature?.roundToInt().toString(),
        humidity = weatherData?.humidity.toString(),
        windSpeed = wind?.windSpeed.toString(),
        description = mainWeather?.first()?.description.toString(),
        icon = Constants.ICON_URL.format(mainWeather?.first()?.icon.toString())
    )
}

data class WeatherUIModel(
    val temperature: String,
    val humidity: String,
    val windSpeed: String,
    val description: String,
    val icon: String
)