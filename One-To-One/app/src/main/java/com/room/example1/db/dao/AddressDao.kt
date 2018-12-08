package com.room.example1.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.room.example1.db.entity.Address

@Dao
interface AddressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAddress(vararg Address: Address): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAddresses(vararg Addresss: Address): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAddresses(Addresss: List<Address>): LongArray

    @Update
    abstract fun updateCustomer(vararg Address: Address)

    @Delete
    abstract fun deleteCustomer(vararg Address: Address)

    @Query("SELECT * FROM address")
    abstract fun loadAllAddresses(): LiveData<List<Address>>

    @Query("SELECT * FROM address WHERE id = :AddressId")
    abstract fun getAddress(AddressId: Int): LiveData<Address>

}