package com.android.carbrew.ui.home.daily

import androidx.lifecycle.ViewModel
import com.android.carbrew.logic.model.Daily
import com.android.carbrew.logic.model.MainPageRepository
import java.util.concurrent.Flow

class DailyViewModel(val repository: MainPageRepository) : ViewModel() {
    var dataList = ArrayList<Daily.Item>()

    fun getPagingData(): Flow<Page>
}