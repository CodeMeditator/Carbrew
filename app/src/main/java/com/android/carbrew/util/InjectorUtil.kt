package com.android.carbrew.util

import com.android.carbrew.logic.dao.CarbrewDatabase
import com.android.carbrew.logic.model.MainPageRepository
import com.android.carbrew.logic.network.CarbrewNetwork
import com.android.carbrew.ui.search.SearchViewModelFactory

object InjectorUtil {
    private fun getMainPageRepository() = MainPageRepository.getInstance(
        CarbrewDatabase.getMainPageDao(), CarbrewNetwork.getInstance()
    )

    fun getSearchViewModelFactory() = SearchViewModelFactory(getMainPageRepository())
}