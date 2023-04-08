package com.weather.chase.domain.repository.local

/**
 * Created by peterx.theja on 2023-04-08.
 */
interface DatastoreRepository {
     fun putLat(key: String, value: String)
     fun putLong(key: String, value: String)
    fun getLat(key: String): String?
    fun getLong(key: String): String?
}