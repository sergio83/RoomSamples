package com.room.example1.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "customers")
data class Customer (@PrimaryKey(autoGenerate = true) var id: Long = 0){

    var name: String? = null

    @Embedded(prefix = "address_")
    var address: Address? = null

    var createDate: Date = Date()
}


