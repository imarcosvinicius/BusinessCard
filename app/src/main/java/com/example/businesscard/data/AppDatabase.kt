package com.example.businesscard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BusinessCard::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun businessDao() : BusinessCardDao

    companion object {
        @Volatile
        private var INSTACE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            return INSTACE ?: synchronized(this) {
                val instace = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "businessCard_de"
                ).build()
                INSTACE = instace
                instace
            }
        }
    }
}

