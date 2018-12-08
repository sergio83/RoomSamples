package com.room.example1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.room.example1.db.AppDatabase
import com.room.example1.db.dao.CustomerDao
import com.room.example1.db.entity.Address
import com.room.example1.db.entity.Customer
import java.util.*


class MainActivity : AppCompatActivity() {

    private var database: AppDatabase? = null
    private var customerDao: CustomerDao? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = AppDatabase.getDatabase(getApplicationContext())
        customerDao = database?.customerDao()

        val customer = createMockCustomer()
        customerDao!!.insertCustomer(customer)

    }

    fun createMockCustomer(): Customer{
        var c = Customer()
        c.address = createMockAddress()
        return c
    }

    fun createMockAddress(): Address{
        val address = Address("street","city","state")
        return address
    }

}
