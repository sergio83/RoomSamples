package com.room.example1.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address")
data class Address(var street: String? = null, var city: String? = null, var state: String? = null) {
    @PrimaryKey(autoGenerate = true) var id: Long  = 0
}