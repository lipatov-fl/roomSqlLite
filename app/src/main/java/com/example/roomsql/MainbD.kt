package com.example.roomsql

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database
abstract class MainbD : RoomDatabase() {
    companion object {
        fun getBd(context: Context): MainbD {
            return Room.databaseBuilder(
                context.applicationContext,
                MainbD::class.java,
                "Test.bd"
            ).build()
        }
    }
}