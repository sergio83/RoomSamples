package com.room.example1.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order( @PrimaryKey(autoGenerate = true) val id: Int) {
    var customerId: Int? = null
    var amount: Float? = null
}