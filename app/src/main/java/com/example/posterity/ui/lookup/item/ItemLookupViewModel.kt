package com.example.posterity.ui.lookup.item

import androidx.lifecycle.ViewModel
import com.example.posterity.data.itemList

class ItemLookupViewModel : ViewModel() {
    val fullItemList = itemList()
}