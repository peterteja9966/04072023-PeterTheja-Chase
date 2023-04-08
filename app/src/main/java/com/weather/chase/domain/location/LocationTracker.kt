package com.weather.chase.domain.location

import android.content.Context
import android.location.Location

/**
 * Created by peterx.theja on 2023-04-05.
 */
interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
    fun getContext(): Context
}