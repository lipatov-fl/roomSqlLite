package com.example.roomsql

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@androidx.room.Entity(tableName = "items")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "Name")
    var name: String,
    @ColumnInfo(name = "Price")
    var price: String,
)