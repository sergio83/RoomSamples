package com.room.example1.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index


@Entity(tableName = "items_orders",
    indices = arrayOf(Index(value = ["itemId", "orderId"], unique = true)),
    primaryKeys = arrayOf("itemId","orderId"),
    foreignKeys = arrayOf(
        ForeignKey(entity = Item::class, parentColumns = arrayOf("id"), childColumns = arrayOf("itemId")),
        ForeignKey(entity = Order::class, parentColumns = arrayOf("id"), childColumns = arrayOf("orderId"))
    ))
data class ItemOrder(val itemId: Long, val orderId: Long, val count: Long)