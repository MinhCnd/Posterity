package com.example.posterity.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    private class AppDatabaseCallback(private val scope: CoroutineScope): Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    Log.d("AppDatabase","populateDatabase()")
                    populateDatabase(database.itemDao())
                }
            }
        }

        fun populateDatabase(itemDao: ItemDao) {
            itemDao.deleteAll()
            // Add sample items
            listOf(Item(0,"Fish","eww",Bin.RUBBISH.ordinal),
            Item(1, "Tin can","rinse and empty", Bin.RECYCLING.ordinal),
            Item(2, "Vegetable","", Bin.COMPOST.ordinal, Bin.RUBBISH.ordinal),
            Item(3, "Laptop","", Bin.RUBBISH.ordinal),
                Item(4, "Takeaway Coffee cups","", Bin.RUBBISH.ordinal),
                Item(5, "Plastic Meat Tray","Rinse and dry", Bin.RECYCLING.ordinal),
                Item(6, "Glass Bottle","Rinse and dry", Bin.RECYCLING.ordinal),
                Item(7, "Lipo Batteries",""),
                Item(8, "Apple","", Bin.COMPOST.ordinal),
                Item(9, "Milk bottles","", Bin.RECYCLING.ordinal),
                Item(10, "Pizza box","", Bin.RECYCLING.ordinal),).forEach {
                Log.d("AppDatabase","inserting $it")
                itemDao.insert(it)
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).addCallback(AppDatabaseCallback(scope)).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}