package com.android.carbrew.logic.network

import com.android.carbrew.logic.network.api.MainPageService

class CarbrewNetwork {
    var mainPageService = ServiceCreator.create(MainPageService::class.java)

    suspend fun fetchHotSearch() = mainPageService.getHotSearch()

}