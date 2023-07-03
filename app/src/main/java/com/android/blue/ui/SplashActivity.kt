package com.android.blue.ui

import android.os.Bundle
import com.android.blue.R
import com.android.blue.ui.common.ui.BaseActivity
import kotlinx.coroutines.delay
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {

    private val splashDuration = 3 * 1000L  // 3s

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun setupViews() {
        super.setupViews()
        lifecycleScope.launch {
            delay(splashDuration)
            MainActivity.start(this@SplashActivity)
            finish()
        }
    }
}