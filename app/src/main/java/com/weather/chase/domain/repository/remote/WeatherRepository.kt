package com.weather.chase.domain.repository.remote

import com.weather.chase.data.mappers.WeatherUIModel
import com.weather.chase.data.remote.WeatherReq
import com.weather.chase.domain.util.Resource

/**
 * Created by peterx.theja on 2023-04-06.
 */
interface WeatherRepository {
    suspend fun getWeatherData(req: WeatherReq): Resource<WeatherUIModel>
}