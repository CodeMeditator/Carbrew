package com.android.carbrew.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.android.carbrew.R
import com.android.carbrew.databinding.ActivityMainBinding
import com.android.carbrew.extension.setOnClickListener
import com.android.carbrew.ui.common.ui.BaseActivity
import com.android.carbrew.ui.home.HomePageFragment
import com.eyepetizer.android.event.RefreshEvent

import org.greenrobot.eventbus.EventBus

class MainActivity : BaseActivity() {

    private var _binding: ActivityMainBinding? = null  // _ means can null

    private val binding: ActivityMainBinding get() = _binding!!

    private var homePageFragment: HomePageFragment? = null

    private val fragmentManager: FragmentManager by lazy { supportFragmentManager }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun setupViews() {
        observe()
        setOnClickListener(
            binding.navigationBar.btnHomePage,
            binding.navigationBar.btnCommunity,
            binding.navigationBar.btnNotification,
            binding.navigationBar.ivRelease,
            binding.navigationBar.btnMine
        ) {
            when (this) {
                binding.navigationBar.btnHomePage -> {
                    notificationUiRefresh(0)
                    setTabSelection(0)

                }


            }
        }

        setTabSelection(0)

    }

    private fun setTabSelection(index: Int) {
        clearAllSelected()
        fragmentManager.beginTransaction().apply {
            hideFragments(this)
            when (index) {
                0 -> {
                    binding.navigationBar.ivHomePage.isSelected = true
                    binding.navigationBar.tvHomePage.isSelected = true
                    if (homePageFragment == null) {
                        homePageFragment = HomePageFragment.newInstance()
                        add(R.id.homeActivityFragContainer, homePageFragment!!)
                    } else {
                        show(homePageFragment!!)
                    }
                }

                1 -> {
                    TODO()
                }
            }
        }.commitAllowingStateLoss()
    }

    private fun clearAllSelected() {
        binding.navigationBar.ivHomePage.isSelected = false
        binding.navigationBar.tvHomePage.isSelected = false
        binding.navigationBar.ivCommunity.isSelected = false
        binding.navigationBar.tvCommunity.isSelected = false
        binding.navigationBar.ivNotification.isSelected = false
        binding.navigationBar.tvNotification.isSelected = false
        binding.navigationBar.ivMine.isSelected = false
        binding.navigationBar.tvMine.isSelected = false
    }

    private fun hideFragments(transaction: FragmentTransaction) {
        transaction.run {
            if (homePageFragment != null) hide(homePageFragment!!)
        }
    }

    private fun notificationUiRefresh(selectionIndex: Int) {
        when (selectionIndex) {
            0 -> {
                if (binding.navigationBar.ivHomePage.isSelected) EventBus.getDefault()
                    .post(RefreshEvent(HomePageFragment::class.java))
            }

            1 -> {
                TODO()
            }
        }
    }

    private fun observe() {

    }


    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

}