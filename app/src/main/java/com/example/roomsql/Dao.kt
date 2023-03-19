package com.example.roomsql

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertItem(item: Entity)
    @Query("SELECT * FROM items")
    fun getAllItem(): Flow<List<Entity>>
}