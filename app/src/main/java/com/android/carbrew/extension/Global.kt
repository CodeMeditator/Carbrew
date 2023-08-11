package com.android.carbrew.extension

import android.view.View
import androidx.datastore.core.DataStore
import com.android.carbrew.CarbrewApplication
import androidx.datastore.preferences.core.Preferences

val dataStore: DataStore<Preferences> = CarbrewApplication.context.dataStore

fun setOnClickListener(vararg v: View?, block: View.() -> Unit) {
    val listener = View.OnClickListener { it.block() }
    v.forEach { it?.setOnClickListener(listener) }
}

fun setOnClickListener(vararg v: View?, listener: View.OnClickListener) {
    v.forEach { it?.setOnClickListener(listener) }
}


