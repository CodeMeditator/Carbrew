package com.android.carbrew.util

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.android.carbrew.extension.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import com.android.carbrew.util.DataStoreUtils.readStringData

object DataStoreUtils {


    fun readStringData(key: String, default: String = ""): String {
        var value = ""
        runBlocking {
            dataStore.data.first {
                value = it[stringPreferencesKey(key)] ?: default
                true
            }
        }
        return value
    }

    suspend fun saveStringData(key: String, value: String) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[stringPreferencesKey(key)] = value
        }
    }

}