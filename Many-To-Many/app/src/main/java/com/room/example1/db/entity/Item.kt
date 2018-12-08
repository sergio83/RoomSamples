package com.room.example1.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item( @PrimaryKey(autoGenerate = true) var id: Long = 0) {
    var itemPrice: Float? = null
    var itemName: String? = null
}