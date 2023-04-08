package com.weather.chase.data.mappers

import com.weather.chase.data.remote.Weather
import com.weather.chase.domain.util.Constants

/**
 * Created by peterx.theja on 2023-04-06.
 */

fun Weather.toIconUrl(): String {
    return Constants.ICON_URL.format(icon)
}