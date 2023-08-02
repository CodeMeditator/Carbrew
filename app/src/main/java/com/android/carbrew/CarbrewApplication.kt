package com.android.carbrew

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class CarbrewApplication : Application() {
    init {

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        context = this

    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}