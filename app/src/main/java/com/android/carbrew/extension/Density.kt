package com.android.carbrew.extension

import com.android.carbrew.CarbrewApplication

/**
 * Change dp to px based on your device's resolution
 */
fun dp2px(dp: Float): Int {
    val scale = CarbrewApplication.context.resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}