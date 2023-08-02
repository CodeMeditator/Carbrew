package com.android.carbrew.logic.network.api

import retrofit2.http.GET

interface MainPageService {
    @GET("api/v3/queries/hot")
    suspend fun getHotSearch(): List<String>
}