package com.example.posterity.ui.lookup.bin

import android.content.Context
import android.database.DataSetObserver
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListAdapter
import android.widget.ListAdapter
import android.widget.TextView
import com.example.posterity.R
import com.example.posterity.data.Bin

class BinListAdapter internal constructor(
    private val context: Context,
    private var binList: List<Bin>
): BaseExpandableListAdapter() {

    override fun getChild(listPosition: Int, expandedListPosition: Int): String {
        return binList[listPosition].description
    }

    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun getChildView(listPosition: Int, expandedListPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convView = convertView
        val expandedItemText = getChild(listPosition, expandedListPosition)

        if (convertView == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convView = layoutInflater.inflate(R.layout.bin_row_item, parent, false)

        }

        val expandedItemTextView = convView!!.findViewById<TextView>(R.id.descriptionView)
        expandedItemTextView.text = expandedItemText
        Log.d("expandedItemTextView","text=$expandedItemText")

        return convView
    }

    override fun getGroupCount(): Int {
        return binList.count()
    }

    override fun getChildrenCount(p0: Int): Int {
        return 1
    }

    override fun getGroup(listPosition: Int): String {
        return binList[listPosition].name
    }

    override fun getGroupId(listPosition: Int): Long {
        Log.d("BinListAdapter", "groupId=$listPosition")
        return listPosition.toLong()
    }

    override fun getGroupView(listPosition: Int,
                              isExpanded: Boolean,
                              convertView: View?,
                              parent: ViewGroup): View {
        var convView = convertView
        val groupTitle = getGroup(listPosition)
        if (convertView == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convView = layoutInflater.inflate(R.layout.bin_group, parent, false)
        }
        val groupTitleTextView = convView!!.findViewById<TextView>(R.id.titleView)
        groupTitleTextView.text = groupTitle

        Log.d("BinListAdapter","convView= $convView")

        return convView
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return false
    }
}