package com.room.example1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.room.example1.db.dao.AddressDao
import com.room.example1.db.dao.CustomerDao
import com.room.example1.db.entity.Address
import com.room.example1.db.entity.Customer
import com.room.example1.db.entity.Item
import com.room.example1.db.entity.Order

@Database(
    entities = [
        Address::class,Customer::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun addressDao(): AddressDao
    abstract fun customerDao(): CustomerDao

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