package com.room.example1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.room.example1.db.AppDatabase
import com.room.example1.db.dao.CustomerDao
import com.room.example1.db.dao.OrderDao
import com.room.example1.db.entity.Address
import com.room.example1.db.entity.Customer
import com.room.example1.db.entity.Order


class MainActivity : AppCompatActivity() {

    private var database: AppDatabase? = null
    private var customerDao: CustomerDao? = null
    private var orderDao: OrderDao? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = AppDatabase.getDatabase(getApplicationContext())
        customerDao = database?.customerDao()
        orderDao = database?.orderDao()

        val customer = createMockCustomer()
        val ids = customerDao!!.insertCustomer(customer)
        val order1 = createMockOrder(ids.get(0).toLong())
        val order2 = createMockOrder(ids.get(0).toLong())
        orderDao!!.insertOrder(order1,order2)

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

    fun createMockOrder(customerId:Long): Order{
        val order = Order(customerId)
        order.amount = 1.0f
        return order
    }

}
