package com.example.posterity.ui.lookup.bin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.posterity.R
import com.example.posterity.data.Bin


class BinAdapter(private val dataSet: List<Bin>) : RecyclerView.Adapter<BinViewHolder>() {

    var expandedPosition = -1
    var previousExpandedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bin_row_item, parent, false)

        return BinViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: BinViewHolder, position: Int) {
        viewHolder.titleView.text = dataSet[position].name
        viewHolder.descriptionView.text = dataSet[position].description
        val isExpanded = position == expandedPosition
        viewHolder.descriptionView.visibility = if (isExpanded) View.VISIBLE else View.GONE
        viewHolder.itemView.isActivated = isExpanded

        if (isExpanded) {
            previousExpandedPosition = position
        }

        if(position == (itemCount - 1) ) {
            viewHolder.divider.visibility = View.GONE
        }

        viewHolder.itemView.setOnClickListener {
            expandedPosition = if (isExpanded) -1 else position
            notifyItemChanged(previousExpandedPosition)
            notifyItemChanged(position)
        }
    }

    override fun getItemCount() = dataSet.size

}