package com.android.carbrew.ui.home.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.carbrew.CarbrewApplication
import com.android.carbrew.databinding.FragmentRefreshLayoutBinding
import com.android.carbrew.extension.showToast
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

    private lateinit var adapter: DailyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRefreshLayoutBinding.inflate(layoutInflater, container, false)
        return super.onCreateView(binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = DailyAdapter(this)
    }

    // test
    override fun onResume() {
        super.onResume()
        Toast.makeText(CarbrewApplication.context, "DailyFragment-->onResume()", Toast.LENGTH_SHORT)
            .show()
    }


    companion object {
        fun newInstance() = DailyFragment()
    }
}