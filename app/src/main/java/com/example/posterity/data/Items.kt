package com.example.posterity.data

import android.content.res.Resources

fun ItemList(resources: Resources) : List<Item> {
    val binList = BinList(resources)
    return listOf(
        Item("Tin can", "rinse and empty", listOf(binList[1])),
        Item("Takeaway coffee cups", "rinse and empty", listOf(binList[0])),
        Item("Plastic Meat Tray", "rinse and dry", listOf(binList[1])),
        Item("Glass Bottles","rinse and dry", listOf(binList[1]))

    )
}