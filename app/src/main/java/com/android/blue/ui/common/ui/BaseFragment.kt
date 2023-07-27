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
import com.android.blue.R
import com.android.blue.extension.logD
import com.android.blue.ui.common.callback.RequestLifecycle
import com.eyepetizer.android.event.MessageEvent
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


open class BaseFragment : Fragment(), RequestLifecycle {

    private var loadErrorView: View? = null
    protected var loading: ProgressBar? = null

    lateinit var activity: Activity
    protected val TAG: String = this.javaClass.simpleName

    /**
     * Fragment中inflate出来的布局。
     */
    protected var rootView: View? = null

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

    fun onCreateView(view: View): View {
        logD(TAG, "BaseFragment-->onCreateView()")
        rootView = view
        return view
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onMessageEvent(messageEvent: MessageEvent) {
        logD(TAG, "BaseFragment-->onMessageEvent()")
    }
}