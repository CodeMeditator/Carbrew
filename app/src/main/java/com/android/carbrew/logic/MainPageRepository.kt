package com.android.carbrew.logic.model

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android.carbrew.Const
import com.android.carbrew.logic.dao.MainPageDao
import com.android.carbrew.logic.network.CarbrewNetwork
import com.android.carbrew.ui.home.daily.DailyPagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class MainPageRepository private constructor(
    private val mainPageDao: MainPageDao, private val carbrewNetwork: CarbrewNetwork
) {

    suspend fun refreshHotSearch() = requestHotSearch()


//    fun getDailyPagingData(): Flow<PagingData<Daily.Item>> {
//        return Pager(config = PagingConfig(Const.Config.PAGE_SIZE),
//            pagingSourceFactory = { DailyPagingSource(carbrewNetwork.mainPageService) }).flow
//    }

    private suspend fun requestHotSearch() = withContext(Dispatchers.IO) {
        val response = carbrewNetwork.fetchHotSearch()
        mainPageDao.cacheHotSearch(response)
        response
    }

    companion object {

        @Volatile
        private var INSTANCE: MainPageRepository? = null

        fun getInstance(dao: MainPageDao, network: CarbrewNetwork): MainPageRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MainPageRepository(dao, network)
            }
    }
}