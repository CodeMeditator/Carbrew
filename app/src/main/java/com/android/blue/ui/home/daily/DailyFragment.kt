package com.android.blue.ui.home.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.android.blue.databinding.FragmentRefreshLayoutBinding
import com.android.blue.ui.common.ui.BaseFragment
import com.android.blue.ui.home.discovery.DiscoveryFragment

class DailyFragment : BaseFragment() {

    private var _binding: FragmentRefreshLayoutBinding? = null

    private val binding
        get() = _binding!!


    private val viewModel by lazy {
        ViewModelProvider(
            this, InjectorUtil.getDailyViewModelFactory()
        ).get(DailyViewModel::class.java)
    }


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