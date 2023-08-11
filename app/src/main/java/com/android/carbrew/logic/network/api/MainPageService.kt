package com.android.carbrew.logic.network.api

import com.android.carbrew.logic.network.ServiceCreator
import retrofit2.http.GET

interface MainPageService {
    @GET("api/v3/queries/hot")
    suspend fun getHotSearch(): List<String>

    companion object {
        const val HOMEPAGE_RECOMMEND_URL = "${ServiceCreator.BASE_URL}api/v5/index/tab/allRec"
    }
}