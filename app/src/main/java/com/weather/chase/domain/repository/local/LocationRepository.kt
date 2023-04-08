package com.weather.chase.domain.repository.local

import android.content.Context

/**
 * Created by peterx.theja on 2023-04-08.
 */
interface LocationRepository {
    fun getLocation(location: String, con: Context): LocationDao
}