package com.example.posterity.ui.lookup.item

import android.graphics.drawable.Icon
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.posterity.R

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val itemName: TextView
    var iconListView: RecyclerView
    private var iconListAdapter : IconAdapter

    init {
        itemName = itemView.findViewById(R.id.item_name)
        iconListView = itemView.findViewById(R.id.icon_list)
        iconListAdapter = IconAdapter()
        iconListView.adapter = iconListAdapter
        val layoutManager = LinearLayoutManager(itemView.context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        iconListView.layoutManager = layoutManager
    }

    fun setIconIdList(newIconIdList: List<Int>) {
        iconListAdapter.setIconIdList(newIconIdList)
    }
}