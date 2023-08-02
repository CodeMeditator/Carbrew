package com.android.carbrew.ui.common.callback

interface RequestLifecycle {
    fun startLoading()

    fun loadFinished()

    fun loadFailed(msg: String?)

}