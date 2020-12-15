package com.example.bmi.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BmiResult::class], version = 1)
abstract class BmiHistoryDatabase : RoomDatabase() {
    abstract fun bmiHistoryDao(): BmiHistoryDao

    companion object {
        @Volatile
        private var INSTANCE: BmiHistoryDatabase? = null

        fun getInstance(context: Context): BmiHistoryDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BmiHistoryDatabase::class.java,
                        "measurements_history"
                    )
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
