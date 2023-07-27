package com.android.blue.ui.home.commend

import com.android.blue.databinding.FragmentRefreshLayoutBinding
import com.android.blue.ui.common.ui.BaseFragment

class CommendFragment : BaseFragment() {

    private var _binding: FragmentRefreshLayoutBinding? = null

    private val binding
        get() = _binding!!

    companion object {
        fun newInstance() = CommendFragment()
    }
}