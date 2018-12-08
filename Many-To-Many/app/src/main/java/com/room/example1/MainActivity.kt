package com.room.example1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.room.example1.db.AppDatabase
import com.room.example1.db.dao.CustomerDao
import com.room.example1.db.dao.ItemDao
import com.room.example1.db.dao.OrderDao
import com.room.example1.db.entity.*


class MainActivity : AppCompatActivity() {

    private var database: AppDatabase? = null
    private var customerDao: CustomerDao? = null
    private var orderDao: OrderDao? = null
    private var itemDao: ItemDao? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = AppDatabase.getDatabase(getApplicationContext())
        customerDao = database?.customerDao()
        orderDao = database?.orderDao()
        itemDao = database?.itemDao()

        val customer = createMockCustomer()
        val ids = customerDao!!.insertCustomer(customer)

        val order1 = createMockOrder(ids.get(0).toLong())
        val order2 = createMockOrder(ids.get(0).toLong())
        val idsOrder = orderDao!!.insertOrder(order1,order2)

        val item1 = createMockItem()
        val item2 = createMockItem()
        val idsItem = itemDao!!.insertItem(item1,item2)

        itemDao!!.insertItemOrder(ItemOrder(idsItem.get(0).toLong(),idsOrder.get(0).toLong(),33))
        itemDao!!.insertItemOrder(ItemOrder(idsItem.get(1).toLong(),idsOrder.get(0).toLong(),36))
        itemDao!!.insertItemOrder(ItemOrder(idsItem.get(1).toLong(),idsOrder.get(1).toLong(),39))
        //itemDao!!.insertItemOrder(ItemOrder(1L,1L,39))
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

    fun createMockItem(): Item {
        val item = Item()
        item.itemName = "name"
        item.itemPrice = 2.0f
        return item
    }


}
