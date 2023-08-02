package com.android.carbrew.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.carbrew.databinding.FragmentHomePageBinding
import com.android.carbrew.logic.model.TabEntity
import com.android.carbrew.ui.common.ui.BaseViewPagerFragment
import com.android.carbrew.ui.home.commend.CommendFragment
import com.eyepetizer.android.event.MessageEvent
import com.eyepetizer.android.event.RefreshEvent
import com.eyepetizer.android.event.SwitchPagesEvent
import com.flyco.tablayout.listener.CustomTabEntity
import org.greenrobot.eventbus.EventBus
import com.android.carbrew.ui.home.discovery.DiscoveryFragment
import com.android.carbrew.ui.home.daily.DailyFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomePageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomePageFragment : BaseViewPagerFragment() {
    private var _binding: FragmentHomePageBinding? = null

    private val binding get() = _binding!!


    override val createTitles = ArrayList<CustomTabEntity>().apply {
        add(TabEntity("Discovery"))
        add(TabEntity("Commend"))
        add(TabEntity("Daily"))
    }

    override val createFragments: Array<Fragment> = arrayOf(
        DiscoveryFragment.newInstance(), CommendFragment.newInstance(), DailyFragment.newInstance()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(layoutInflater, container, false)
        return super.onCreateView(binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager?.currentItem = 1
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMessageEvent(messageEvent: MessageEvent) {
        super.onMessageEvent(messageEvent)
        if (messageEvent is RefreshEvent && this::class.java == messageEvent.activityClass) {
            when (viewPager?.currentItem) {
                0 -> EventBus.getDefault().post(RefreshEvent(DiscoveryFragment::class.java))
                1 -> EventBus.getDefault().post(RefreshEvent(CommendFragment::class.java))
                2 -> EventBus.getDefault().post(RefreshEvent(DailyFragment::class.java))
            }
        } else if (messageEvent is SwitchPagesEvent) {
            when (messageEvent.activityClass) {
                DiscoveryFragment::class.java -> viewPager?.currentItem = 0
                CommendFragment::class.java -> viewPager?.currentItem = 1
                DailyFragment::class.java -> viewPager?.currentItem = 2
            }
        }
    }

    companion object {
        fun newInstance() = HomePageFragment()
    }

}