package com.example.posterity.ui.lookup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LookupViewModel : ViewModel() {

    companion object {
        enum class LOOKUP{
            BIN,
            ITEM
        }
    }

    val lastLookupFragmentType = MutableLiveData<LOOKUP>().apply {
        value = LOOKUP.BIN
    }



}