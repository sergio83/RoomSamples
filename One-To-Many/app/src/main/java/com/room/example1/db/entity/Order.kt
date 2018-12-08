package com.room.example1.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(var customerId: Long) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
    var amount: Float? = null
}