package com.room.example1.db.entity

import androidx.room.*
import java.util.*

@Entity(tableName = "customers")
data class Customer (@PrimaryKey(autoGenerate = true) var id: Long = 0){

    var name: String? = null

    @Embedded(prefix = "address_")
    var address: Address? = null

    var createDate: Date = Date()

    @Ignore
    var orders: List<Order>? = null

}

