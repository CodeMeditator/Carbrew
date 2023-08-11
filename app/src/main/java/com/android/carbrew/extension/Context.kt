package com.android.carbrew.extension

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.android.carbrew.CarbrewApplication

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = CarbrewApplication.context.packageName + "_preferences",
    produceMigrations = { context ->
        listOf(
            SharedPreferencesMigration(
                context, CarbrewApplication.context.packageName + "_preferences"
            )
        )
    })