package com.room.example1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.room.example1.db.Convertes.DateTypeConverter
import com.room.example1.db.dao.CustomerDao
import com.room.example1.db.dao.ItemDao
import com.room.example1.db.dao.OrderDao
import com.room.example1.db.entity.*

@Database(
    entities = [
        Order::class,Customer::class, Item::class,ItemOrder::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun customerDao(): CustomerDao
    abstract fun orderDao(): OrderDao
    abstract fun itemDao(): ItemDao

    companion object {

        private var sInstance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (sInstance == null) {
                sInstance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java,
                    "basic.db"
                ).allowMainThreadQueries().build()

            }
            return sInstance!!
        }

        fun onDestroy() {
            sInstance = null
        }
    }
}