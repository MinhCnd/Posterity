package com.example.posterity.ui.lookup.item

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.posterity.R
import com.example.posterity.data.Item

class ItemAdapter(private var itemList: List<Item>) : RecyclerView.Adapter<ItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_row_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ItemViewHolder, position: Int) {
        viewHolder.itemName.text = itemList[position].name
        viewHolder.itemView.setOnClickListener {
            Log.d("ItemAdapter","Item ${itemList[position].name} clicked")
        }
    }

    override fun getItemCount() = itemList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItemList(newItemList: List<Item>) {
        if (itemList != newItemList) {
            itemList = newItemList
            notifyDataSetChanged()
        }
    }

}