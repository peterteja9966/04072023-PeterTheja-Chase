package com.weather.chase.data.repository.local

import android.content.Context
import android.location.Geocoder
import com.weather.chase.domain.repository.local.LocationDao
import com.weather.chase.domain.repository.local.LocationRepository
import java.util.*
import javax.inject.Inject

/**
 * Created by peterx.theja on 2023-04-07.
 */
class LocationRepositoryImpl @Inject constructor(): LocationRepository {
    override fun getLocation(location: String, con: Context): LocationDao {
        val gc = Geocoder(con, Locale.getDefault())
        val locations = gc.getFromLocationName(location, 1)
        return LocationDao(
            lat = locations.first().latitude.toString(),
            long = locations.first().longitude.toString()
        )
    }
}