package com.weather.chase.di

import com.weather.chase.data.repository.remote.WeatherRepositoryImpl
import com.weather.chase.domain.repository.remote.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

/**
 * Created by peterx.theja on 2023-04-05.
 */
@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRemoteRepository(weatherRepository: WeatherRepositoryImpl)
            : WeatherRepository
}