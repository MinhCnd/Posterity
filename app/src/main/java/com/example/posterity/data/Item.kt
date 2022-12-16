package com.example.posterity.data

data class Item(
    val name: String,
    val preDisposalInstruction: String,
    val binDesignation: List<Bin>
)
