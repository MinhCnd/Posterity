package com.example.posterity.data

fun itemList() : List<Item> {
    return listOf(
        Item("Tin can", "rinse and empty", setOf(Bin.RECYCLING)),
        Item("Takeaway coffee cups", "rinse and empty", setOf(Bin.RUBBISH)),
        Item("Plastic Meat Tray", "rinse and dry", setOf(Bin.RECYCLING)),
        Item("Glass Bottles","rinse and dry", setOf(Bin.RECYCLING)),
        Item("Apple, Vegetable","", setOf(Bin.COMPOST,Bin.RUBBISH))

    )
}