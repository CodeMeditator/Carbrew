package com.android.carbrew.extension

import android.view.View
import android.view.animation.AlphaAnimation

/**
 * 显示view，带有渐显动画效果。
 *
 * @param duration 毫秒，动画持续时长，默认500毫秒。
 */
fun View?.visibleAlphaAnimation(duration: Long = 500L) {
    this?.visibility = View.VISIBLE
    this?.startAnimation(AlphaAnimation(0f, 1f).apply {
        this.duration = duration
        fillAfter = true
    })
}

fun View?.visible() {
    this?.visibility = View.VISIBLE
}

fun View?.gone() {
    this?.visibility = View.GONE
}