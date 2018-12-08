package com.room.example1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.room.example1.db.AppDatabase
import com.room.example1.db.dao.CustomerDao
import com.room.example1.db.entity.Address
import com.room.example1.db.entity.Customer
import com.room.example1.db.entity.CustomerAndAllOrders
import com.room.example1.db.entity.Order
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    private var database: AppDatabase? = null
    private var customerDao: CustomerDao? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = AppDatabase.getDatabase(getApplicationContext())
        customerDao = database?.customerDao()


        val customer = createMockCustomer()
        val order1 = createMockOrder()
        val order2 = createMockOrder()
        val pp = CustomerAndAllOrders()
        pp.customer = customer
        val list = ArrayList<Order>()
        list.add(order1)
        list.add(order2)
        pp.orders = list

        /*
        val ids = customerDao!!.insertCustomer(customer)
        order1.customerId = ids.get(0).toLong()
        order2.customerId = ids.get(0).toLong()
        customerDao!!.insertOrders(order1)
        customerDao!!.insertOrders(order2)
        */

      //  var obj = customerDao!!.getCustomers()

        var obj = customerDao!!.getCustomer(1)
        Log.e("APPXX",""+obj)
 //       Log.e("APPX",""+obj.value!!.customer.id)
  //      Log.e("APPX",""+obj.value!!.orders.size)

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

    fun createMockOrder(): Order{
        val order = Order()
        order.amount = 1.0f
        return order
    }

}
