package com.example.posterity.ui.lookup.item

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.posterity.R
import com.example.posterity.data.Bin
import com.example.posterity.data.Item
import com.example.posterity.ui.lookup.bin.getBinIcon

class ItemAdapter(private var itemList: List<Item>, private val itemClickCallback: ((Int) -> Unit)?) : RecyclerView.Adapter<ItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_row_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ItemViewHolder, position: Int) {
        viewHolder.itemName.text = itemList[position].name
        val iconList = mutableListOf<Bin>()
        itemList[position].mainBinDesignation?.let { iconList.add(Bin.values()[it])}
        itemList[position].secondaryBinDesignation?.let { iconList.add(Bin.values()[it])}
        viewHolder.setIconIdList(iconList.map { getBinIcon(it)})

        viewHolder.itemView.setOnClickListener {
            itemClickCallback?.invoke(itemList[position].id)
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