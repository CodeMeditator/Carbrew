package com.android.carbrew.logic.network

import com.android.carbrew.logic.network.api.MainPageService

class CarbrewNetwork {
    var mainPageService = ServiceCreator.create(MainPageService::class.java)
        private set

    suspend fun fetchHotSearch() = mainPageService.getHotSearch()

    companion object {
        @Volatile
        private var INSTANCE: CarbrewNetwork? = null

        fun getInstance(): CarbrewNetwork = INSTANCE ?: synchronized(this) {
            INSTANCE ?: CarbrewNetwork()
        }
    }
}