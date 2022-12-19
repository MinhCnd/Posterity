package com.example.posterity.ui.lookup.bin

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.posterity.R
import com.example.posterity.data.Bin


class BinAdapter(private val dataSet: List<Bin>) : RecyclerView.Adapter<BinViewHolder>() {

    private var expandedPosition = -1
    private var previousExpandedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bin_row_item, parent, false)

        return BinViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: BinViewHolder, @SuppressLint("RecyclerView") position: Int) {
        viewHolder.titleView.text = getBinName(dataSet[position], viewHolder.itemView.resources)
        viewHolder.descriptionView.text = getBinDescription(dataSet[position], viewHolder.itemView.resources)
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