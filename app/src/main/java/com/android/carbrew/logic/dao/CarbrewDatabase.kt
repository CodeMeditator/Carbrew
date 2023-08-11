package com.android.carbrew.logic.dao

object CarbrewDatabase {
    private lateinit var mainPageDao: MainPageDao
//    private lateinit var videoDao: VideoDao

    fun getMainPageDao() = if (this::mainPageDao.isInitialized) mainPageDao else MainPageDao()

}