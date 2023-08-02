package com.android.carbrew.extension

import android.widget.Toast
import com.android.carbrew.CarbrewApplication

fun Int.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(CarbrewApplication.context, this, duration).show()
}