package com.android.carbrew.ui.search

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.carbrew.Const

class HotSearchAdapter(val fragment: SearchFragment, var dataList: List<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TAG = "HotSearchAdapter"
        const val HOT_SEARCH_TYPE = Const.ItemViewType.MAX
    }

    override fun getItemCount() = dataList.size + 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}
