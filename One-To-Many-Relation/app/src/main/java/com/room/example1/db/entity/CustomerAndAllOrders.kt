package com.room.example1.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation


class CustomerAndAllOrders {

    @Embedded
    lateinit var customer: Customer

    //Doc: https://developer.android.com/reference/android/arch/persistence/room/Relation
    @Relation(parentColumn = "id", entityColumn = "customerId", entity = Order::class)
    lateinit var orders: List<Order>

}

