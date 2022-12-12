package com.example.posterity.data

import android.content.res.Resources
import com.example.posterity.R

fun BinList(resources: Resources) : List<Bin> {
    return listOf(
        Bin(
            name = resources.getString(R.string.bin_rubbish),
            description = resources.getString(R.string.bin_rubbish_description)
        ),
        Bin(
            name = resources.getString(R.string.bin_recycling),
            description = resources.getString(R.string.bin_recycling_description)
        ),
        Bin(
            name = resources.getString(R.string.bin_garden_waste),
            description = resources.getString(R.string.bin_garden_waste_description)
        ),
        Bin(
            name = resources.getString(R.string.bin_compost),
            description = resources.getString(R.string.bin_compost_description)
        )
    )
}