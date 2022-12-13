package com.example.posterity.ui.lookup.bin

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.posterity.R

class BinViewHolder(itemView: View) : ViewHolder(itemView) {
    val titleView: TextView
    val descriptionView: TextView
    val divider: View

    init {

        titleView = itemView.findViewById(R.id.titleView)
        descriptionView = itemView.findViewById(R.id.descriptionView)
        divider = itemView.findViewById(R.id.divider)
    }
}