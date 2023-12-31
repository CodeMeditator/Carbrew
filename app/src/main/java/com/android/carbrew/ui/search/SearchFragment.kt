package com.android.carbrew.ui.search

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.carbrew.R
import com.android.carbrew.databinding.FragmentSearchBinding
import com.android.carbrew.extension.logW
import com.android.carbrew.extension.setDrawable
import com.android.carbrew.extension.visibleAlphaAnimation
import com.android.carbrew.ui.common.ui.BaseFragment
import com.android.carbrew.extension.showToast
import com.android.carbrew.ui.common.ui.BaseActivity
import com.android.carbrew.util.InjectorUtil

class SearchFragment : BaseFragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(
            this, InjectorUtil.getSearchViewModelFactory()
        ).get(SearchViewModel::class.java)
    }

    private lateinit var adapter: HotSearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return super.onCreateView(binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.llSearch.visibleAlphaAnimation(500)
        binding.etQuery.setDrawable(
            ContextCompat.getDrawable(
                activity, R.drawable.ic_search_gray_17dp
            ), 14f, 14f
        )
        binding.etQuery.setOnEditorActionListener(EditorActionListener(activity, binding))
        binding.tvCancel.setOnClickListener {
            hideSoftKeyboard()
            removeFragment(activity, this)
        }
        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        adapter = HotSearchAdapter(this, viewModel.dataList)
        binding.recyclerView.adapter = adapter
        viewModel.onRefresh()
        observe()
    }

    override fun onDestroy() {
        super.onDestroy()
        hideSoftKeyboard()
        _binding = null
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observe() {
        viewModel.dataListLiveData.observe(viewLifecycleOwner, Observer { result ->
            binding.etQuery.showSoftKeyboard()
            val response = result.getOrNull()
            if (response == null) {
                result.exceptionOrNull()?.printStackTrace()
                return@Observer
            }
            if (response.isNullOrEmpty() && viewModel.dataList.isEmpty()) {
                return@Observer
            }
            if (response.isNullOrEmpty() && viewModel.dataList.isNotEmpty()) {
                return@Observer
            }
            viewModel.dataList.clear()
            viewModel.dataList.addAll(response)
            adapter.notifyDataSetChanged()
        })
    }


    private fun hideSoftKeyboard() {
        try {
            activity.currentFocus?.run {
                val imm =
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(this.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            }
        } catch (e: Exception) {
            logW(TAG, e.message, e)
        }
    }

    private fun View.showSoftKeyboard() {
        try {
            this.isFocusable = true
            this.isFocusableInTouchMode = true
            this.requestFocus()
            val manager =
                activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            manager.showSoftInput(this, 0)
        } catch (e: Exception) {
            logW(TAG, e.message, e)
        }
    }

    class EditorActionListener(val activity: Context, val binding: FragmentSearchBinding) :
        TextView.OnEditorActionListener {
        override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (binding.etQuery.text.toString().isEmpty()) {
                    R.string.input_keywords_tips.showToast()
                    return false
                }
                R.string.currently_not_supported.showToast()
                return true
            }
            return true
        }

    }

    companion object {
        fun switchFragment(activity: Activity) {
            (activity as BaseActivity).supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, SearchFragment()).addToBackStack(null)
                .commitAllowingStateLoss()
        }

        fun removeFragment(activity: Activity, fragment: Fragment) {
            (activity as BaseActivity).supportFragmentManager.run {
                beginTransaction().remove(fragment).commitAllowingStateLoss()
                popBackStack()
            }
        }

    }

}