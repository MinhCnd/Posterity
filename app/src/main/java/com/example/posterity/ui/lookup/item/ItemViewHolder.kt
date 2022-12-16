package com.example.posterity.ui.lookup.item

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.posterity.R

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val searchIcon: ImageView
    val itemName: TextView

    init {

        searchIcon = itemView.findViewById(R.id.search_icon)
        itemName = itemView.findViewById(R.id.item_name)
    }
}