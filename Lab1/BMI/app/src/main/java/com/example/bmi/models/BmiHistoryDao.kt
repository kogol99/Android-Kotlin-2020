package com.example.bmi.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BmiHistoryDao {
    @Insert
    fun insert(holder: BmiResult)

    @Query("SELECT * FROM measurements_history")
    fun getHistory(): List<BmiResult>
}
