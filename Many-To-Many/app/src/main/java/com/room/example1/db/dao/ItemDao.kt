package com.room.example1.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.room.example1.db.entity.Item
import com.room.example1.db.entity.ItemOrder

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertItem(vararg item: Item): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertItems(vararg items: Item): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertItems(items: List<Item>): LongArray

    @Update
    abstract fun updateItem(vararg item: Item)

    @Delete
    abstract fun deleteItem(vararg item: Item)

    @Query("SELECT * FROM items")
    abstract fun loadAllItems(): LiveData<List<Item>>

    @Query("SELECT * FROM items WHERE id = :itemId")
    abstract fun getItem(itemId: Int): LiveData<Item>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertItemOrder(vararg itemOrder: ItemOrder): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertItemOrders(vararg itemOrder: ItemOrder): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertItemOrders(itemOrders: List<ItemOrder>): LongArray

}