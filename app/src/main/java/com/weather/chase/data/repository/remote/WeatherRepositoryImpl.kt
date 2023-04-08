package com.weather.chase.data.repository.remote

import com.weather.chase.data.mappers.WeatherUIModel
import com.weather.chase.data.mappers.toUIModels
import com.weather.chase.data.remote.WeatherApi
import com.weather.chase.data.remote.WeatherReq
import com.weather.chase.domain.repository.remote.WeatherRepository
import com.weather.chase.domain.util.Resource
import javax.inject.Inject

/**
 * Created by peterx.theja on 2023-04-06.
 */
class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeatherData(req: WeatherReq): Resource<WeatherUIModel> {
        return try {
            Resource.Success(
                data = api.getCurrentWeather(
                    lat = req.lat,
                    lon = req.lon
                ).toUIModels()
            )
        } catch (ex: Exception) {
            ex.printStackTrace()
            Resource.Error(ex.message ?: "An unknown error occurred.")
        }
    }
}