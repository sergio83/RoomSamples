package com.room.example1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.room.example1.db.Convertes.DateTypeConverter
import com.room.example1.db.dao.CustomerDao
import com.room.example1.db.entity.Address
import com.room.example1.db.entity.Customer

@Database(
    entities = [
        Customer::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

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