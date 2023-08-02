package com.android.carbrew.ui.home.commend

import com.android.carbrew.databinding.FragmentRefreshLayoutBinding
import com.android.carbrew.ui.common.ui.BaseFragment

class CommendFragment : BaseFragment() {

    private var _binding: FragmentRefreshLayoutBinding? = null

    private val binding
        get() = _binding!!

    companion object {
        fun newInstance() = CommendFragment()
    }
}