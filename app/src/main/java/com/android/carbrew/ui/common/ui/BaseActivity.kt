package com.android.carbrew.ui.common.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.carbrew.extension.logD

open class BaseActivity : AppCompatActivity() {

    protected val TAG: String = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logD(TAG, "BaseActivity-->onCreate()")
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
//        setStatusBarBackground(R.color.colorPrimaryDark)
        setupViews()
    }

    override fun setContentView(layoutView: View) {
        super.setContentView(layoutView)
//        setStatusBarBackground(R.color.colorPrimaryDark)
        setupViews()
    }

    protected open fun setupViews() {

    }


    private fun observe() {

    }
}