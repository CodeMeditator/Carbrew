package com.android.blue.ui

import android.content.Context
import android.content.Intent
import android.os.BaseBundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.blue.R
import com.android.blue.databinding.ActivityMainBinding
import com.android.blue.extension.setOnClickListener
import com.android.blue.ui.common.ui.BaseActivity

class MainActivity : BaseActivity() {

    private var _binding: ActivityMainBinding? = null  // _ means can null

    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun setupViews() {
        observe()
//        setOnClickListener(binding.navi)

    }

    private fun observe() {

    }


    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

}