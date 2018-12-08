package com.room.example1.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(foreignKeys = [(ForeignKey(entity = Customer::class,
    parentColumns = ["id"],
    childColumns = ["customerId"],
    onDelete = CASCADE))
])
data class Order(@PrimaryKey(autoGenerate = true) var id: Long = 0) {
    var amount: Float? = null
    var customerId: Long = 0
}

