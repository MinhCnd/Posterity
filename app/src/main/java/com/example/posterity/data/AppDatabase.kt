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
            listOf(Item(0,"Fish",Bin.RUBBISH.ordinal,"throw them out"),
            Item(1, "Tin can",Bin.RECYCLING.ordinal,"rinse and empty"),
            Item(2, "Vegetable", Bin.COMPOST.ordinal,"rinse and empty", Bin.RUBBISH.ordinal),
            Item(3, "Laptop", Bin.RUBBISH.ordinal,""),
                Item(4, "Takeaway Coffee cups", Bin.RUBBISH.ordinal,""),
                Item(5, "Plastic Meat Tray", Bin.RECYCLING.ordinal,"Rinse and dry"),
                Item(6, "Glass Bottle", Bin.RECYCLING.ordinal,"Rinse and dry"),
                Item(7, "Lipo Batteries"),
                Item(8, "Apple", Bin.COMPOST.ordinal,""),
                Item(9, "Milk bottles", Bin.RECYCLING.ordinal,""),
                Item(10, "Pizza box", Bin.RECYCLING.ordinal,""),
                Item(11,"plastic chair", Bin.RUBBISH.ordinal,""),
                Item(12, "pot plant", Bin.RUBBISH.ordinal, ""),
                Item(13,"Chicken feet", Bin.RUBBISH.ordinal,""),).forEach {
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