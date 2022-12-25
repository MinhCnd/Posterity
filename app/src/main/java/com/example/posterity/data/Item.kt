package com.example.posterity.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String? = null,
    @ColumnInfo(name = "pre_disposal_instruction") val preDisposalInstruction: String? = null,
    @ColumnInfo(name = "main_bin_type") val binDesignation: Int? = null,
    @ColumnInfo(name = "sub_bin_type") val subBinDesignation: Int? = null
)
