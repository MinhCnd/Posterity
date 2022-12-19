package com.example.posterity.ui.lookup.item

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.posterity.R

class IconAdapter() : RecyclerView.Adapter<IconViewHolder>(){
    private var iconIdList = emptyList<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.icon_item, parent, false)

        return IconViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: IconViewHolder, position: Int) {
        viewHolder.icon.setImageResource(iconIdList[position])
    }

    override fun getItemCount() = iconIdList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setIconIdList(newIconIdList: List<Int>) {
        iconIdList = newIconIdList
        notifyDataSetChanged()
    }

}