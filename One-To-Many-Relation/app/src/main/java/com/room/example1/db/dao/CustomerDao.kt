package com.room.example1.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.room.example1.db.entity.Customer
import com.room.example1.db.entity.CustomerAndAllOrders
import com.room.example1.db.entity.Order

@Dao
interface CustomerDao {

    @Query("SELECT * FROM customers")
    abstract fun getCustomers(): List<CustomerAndAllOrders>

    @Query("SELECT * FROM customers WHERE id = :id")
    abstract fun getCustomer(id: Long): CustomerAndAllOrders

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertOrders(vararg orders: Order)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCustomer(vararg customer: Customer): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCustomers(vararg customers: Customer): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCustomers(customers: List<Customer>): LongArray

    @Update
    abstract fun updateCustomer(vararg customer: Customer)

    @Delete
    abstract fun deleteCustomer(vararg customer: Customer)

    @Query("SELECT * FROM customers")
    abstract fun loadAllCustomers(): LiveData<List<Customer>>

    @Query("SELECT * FROM customers WHERE id = :customerId")
    abstract fun getCustomer(customerId: Int): LiveData<Customer>

}