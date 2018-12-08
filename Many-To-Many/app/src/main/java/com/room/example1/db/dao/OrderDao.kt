package com.room.example1.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.room.example1.db.entity.Order

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertOrder(vararg Order: Order): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertOrders(vararg Orders: Order): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertOrders(Orders: List<Order>): LongArray

    @Update
    abstract fun updateOrder(vararg Order: Order)

    @Delete
    abstract fun deleteOrder(vararg Order: Order)

    @Query("SELECT * FROM Orders")
    abstract fun loadAllOrders(): LiveData<List<Order>>

    @Query("SELECT * FROM Orders WHERE id = :OrderId")
    abstract fun getOrder(OrderId: Int): LiveData<Order>

}