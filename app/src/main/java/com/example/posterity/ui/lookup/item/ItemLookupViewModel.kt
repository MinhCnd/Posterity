package com.example.posterity.ui.lookup.item

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.posterity.data.AppRepository

class ItemLookupViewModel(repository: AppRepository) : ViewModel() {
    val fullItemList = repository.allItems.asLiveData()
}

class ItemLookupViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.d("ItemLookupViewModel", modelClass.toString())
        if(modelClass.isAssignableFrom(ItemLookupViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemLookupViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}