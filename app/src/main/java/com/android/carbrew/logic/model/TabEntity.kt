package com.android.carbrew.logic.model

import com.flyco.tablayout.listener.CustomTabEntity

class TabEntity(
    private val title: String,
    private val selectedIcon: Int = 0,
    private val unSelectedIcon: Int = 0
) : CustomTabEntity {
    override fun getTabTitle() = title

    override fun getTabSelectedIcon() = selectedIcon

    override fun getTabUnselectedIcon() = unSelectedIcon
}