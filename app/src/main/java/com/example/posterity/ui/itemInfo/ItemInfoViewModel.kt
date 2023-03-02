package com.example.posterity.ui.itemInfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.posterity.data.Item

class ItemInfoViewModel : ViewModel() {
    val item = MutableLiveData<Item>()

    fun setItem(item: Item) {
        this.item.value = item
    }
}