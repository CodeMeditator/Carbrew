package com.android.carbrew.ui.home.daily

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.carbrew.extension.gone
import com.android.carbrew.extension.setOnClickListener
import com.android.carbrew.extension.visible
import com.android.carbrew.logic.model.Daily
import com.android.carbrew.ui.common.holder.RecyclerViewHelp
import com.android.carbrew.ui.common.holder.TextCardViewHeader4ViewHolder
import com.android.carbrew.ui.common.holder.TextCardViewHeader5ViewHolder

/**
 * GET dataType: TextCard header 5, FollowCard, VideoBeanForClient
 */

class DailyAdapter(val fragment: DailyFragment) :
    PagingDataAdapter<Daily.Item, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    override fun getItemViewType(position: Int) =
        RecyclerViewHelp.getItemViewType(getItem(position)!!)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecyclerViewHelp.getViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)!!
        when (holder) {
            is TextCardViewHeader5ViewHolder -> {
                holder.tvTitle5.text = item.data.text
                if (item.data.actionUrl != null) holder.ivInto5.visible() else holder.ivInto5.gone();
                if (item.data.follow != null) holder.tvFollow.visible() else holder.tvFollow.gone()
                holder.tvFollow.setOnClickListener {
//                    LoginActivity.start(fragment.activity)
                }
                setOnClickListener(holder.tvTitle5, holder.ivInto5) {
                    ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.text)
                }
            }

        }
    }


    companion object {
        const val TAG = "DailyAdapter"
        const val DEFAULT_LIBRARY_TYPE = "DEFAULT"
        const val NONE_LIBRARY_TYPE = "NONE"
        const val DAILY_LIBRARY_TYPE = "DAILY"

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Daily.Item>() {
            override fun areItemsTheSame(oldItem: Daily.Item, newItem: Daily.Item) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Daily.Item, newItem: Daily.Item) =
                oldItem == newItem

        }
    }

}