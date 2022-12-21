package com.example.posterity.ui.lookup.bin

import android.content.res.Resources
import com.example.posterity.R
import com.example.posterity.data.Bin

fun getBinName(bin:Bin, resources: Resources): String {
    return when(bin) {
        Bin.RUBBISH -> resources.getString(R.string.bin_rubbish)
        Bin.RECYCLING -> resources.getString(R.string.bin_recycling)
        Bin.COMPOST -> resources.getString(R.string.bin_compost)
        Bin.GARDEN_WASTE -> resources.getString(R.string.bin_garden_waste)
    }
}

fun getBinIcon(bin: Bin): Int {
    return when(bin) {
        Bin.RUBBISH -> R.drawable.ic_bin_rubbish
        Bin.RECYCLING -> R.drawable.ic_bin_recycling
        Bin.COMPOST -> R.drawable.ic_bin_compost
        Bin.GARDEN_WASTE -> R.drawable.ic_bin_compost
    }
}

fun getBinDescription(bin: Bin, resources: Resources): String  {
    return when(bin) {
        Bin.RUBBISH -> resources.getString(R.string.bin_rubbish_description)
        Bin.RECYCLING -> resources.getString(R.string.bin_recycling_description)
        Bin.COMPOST -> resources.getString(R.string.bin_compost_description)
        Bin.GARDEN_WASTE -> resources.getString(R.string.bin_garden_waste_description)
    }
}