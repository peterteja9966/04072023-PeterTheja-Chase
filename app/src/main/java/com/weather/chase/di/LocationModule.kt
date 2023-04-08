package com.weather.chase.di

import com.weather.chase.data.location.DefaultLocationTracker
import com.weather.chase.data.repository.local.LocationRepositoryImpl
import com.weather.chase.data.repository.remote.DataStoreRepositoryImpl
import com.weather.chase.domain.location.LocationTracker
import com.weather.chase.domain.repository.local.DatastoreRepository
import com.weather.chase.domain.repository.local.LocationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by peterx.theja on 2023-04-05.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {

    @Singleton
    @Binds
    abstract fun bindLocationPermissionTracker(defaultLocationTracker: DefaultLocationTracker): LocationTracker

    @Singleton
    @Binds
    abstract fun bindLocationRepository(weatherRepository: LocationRepositoryImpl)
            : LocationRepository

    @Singleton
    @Binds
    abstract fun bindDataStoreRepository(weatherRepository: DataStoreRepositoryImpl)
            : DatastoreRepository
}