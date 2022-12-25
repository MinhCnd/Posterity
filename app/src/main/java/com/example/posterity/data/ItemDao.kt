package com.example.posterity.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM item_table")
    fun getAll(): Flow<List<Item>>

    @Query("SELECT * FROM item_table WHERE id IN (:itemIds)")
    fun loadAllByIds(itemIds: IntArray): List<Item>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: Item)

    @Insert
    fun insertAll(vararg item: Item)

    @Delete
    fun delete(item: Item)

    @Query("DELETE FROM item_table")
    fun deleteAll()
}