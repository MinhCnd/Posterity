package com.example.posterity.ui.lookup.item

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class IconViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
    val icon: ImageView

    init {
        icon = itemView as ImageView
    }
}