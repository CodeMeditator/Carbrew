package com.android.blue.ui.common.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.android.blue.extension.logD
import com.android.blue.ui.common.callback.RequestLifecycle


open class BaseFragment : Fragment(), RequestLifecycle {

    private var loadErrorView: View? = null
    protected var loading: ProgressBar? = null

    lateinit var activity: Activity
    protected val TAG: String = this.javaClass.simpleName

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // cache
        activity = requireActivity()
        logD(TAG, "BaseFragment-->onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logD(TAG, "BaseFragment-->onCreate()")
    }

    override fun startLoading() {
        loading?.visibility = View.VISIBLE
        hideLoadErrorView()
    }

    override fun loadFinished() {
        loading?.visibility = View.GONE
    }

    override fun loadFailed(msg: String?) {
        loading?.visibility = View.GONE
    }

    protected fun hideLoadErrorView() {
        loadErrorView?.visibility = View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        logD(TAG, "BaseFragment-->onCreateView()")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    fun onCreateView(view: View) {
        logD(TAG, "BaseFragment-->onCreateView()")

    }

}