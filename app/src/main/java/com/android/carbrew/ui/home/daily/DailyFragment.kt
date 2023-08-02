package com.android.carbrew.ui.home.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.carbrew.databinding.FragmentRefreshLayoutBinding
import com.android.carbrew.ui.common.ui.BaseFragment

class DailyFragment : BaseFragment() {

    private var _binding: FragmentRefreshLayoutBinding? = null

    private val binding
        get() = _binding!!


//    private val viewModel by lazy {
//        ViewModelProvider(
//            this, InjectorUtil.getDailyViewModelFactory()
//        ).get(DailyViewModel::class.java)
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRefreshLayoutBinding.inflate(layoutInflater, container, false)
        return super.onCreateView(binding.root)
    }


    companion object {
        fun newInstance() = DailyFragment()
    }
}