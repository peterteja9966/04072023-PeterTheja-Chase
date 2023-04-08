package com.weather.chase.data.repository.remote

import android.content.Context
import androidx.datastore.core.DataStore
import com.weather.chase.domain.repository.local.DatastoreRepository
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.weather.chase.domain.location.LocationTracker
import com.weather.chase.domain.util.Constants
import javax.inject.Inject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

/**
 * Created by peterx.theja on 2023-04-08.
 */

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constants.PREFERENCE_NAME)

class DataStoreRepositoryImpl @Inject constructor(
    private val location: LocationTracker
) : DatastoreRepository {
    override fun putLat(key: String, value: String) {
        runBlocking {
            val latKey = stringPreferencesKey(key)
            location.getContext().dataStore.edit {
                it[latKey] = value
            }
        }

    }

    override fun putLong(key: String, value: String) {
        runBlocking {
            val longKey = stringPreferencesKey(key)
            location.getContext().dataStore.edit {
                it[longKey] = value
            }
        }
    }

    override fun getLat(key: String): String? {
        return try {
            runBlocking {
                val preferenceKey = stringPreferencesKey(key)
                val preference = location.getContext().dataStore.data.first()
                preference[preferenceKey]
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
    }

    override fun getLong(key: String): String? {
        return try {
            runBlocking {
                val preferenceKey = stringPreferencesKey(key)
                val preference = location.getContext().dataStore.data.first()
                preference[preferenceKey]
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
    }
}