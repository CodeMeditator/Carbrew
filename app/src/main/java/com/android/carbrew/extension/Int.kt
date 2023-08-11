package com.android.carbrew.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.carbrew.CarbrewApplication

fun Int.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(CarbrewApplication.context, this, duration).show()
}

fun Int.inflate(parent: ViewGroup, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(parent.context).inflate(this, parent, attachToRoot)
}
