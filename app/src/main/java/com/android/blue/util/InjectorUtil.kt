package com.android.blue.util

object InjectorUtil {
    fun getDailyViewModelFactory() = DailyViewModelFactory(getMainPageRepository())
}