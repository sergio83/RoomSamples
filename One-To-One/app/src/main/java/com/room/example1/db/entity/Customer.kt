package com.room.example1.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customers")
data class Customer (
    var name: String?,
    var addressId: Long?
){
    @PrimaryKey var id: Long = 0
}


