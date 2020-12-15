package com.example.bmi.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "measurements_history")
data class BmiResult(
    @PrimaryKey(autoGenerate = true) private var id: Int = 0,
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "weight") val weight: String?,
    @ColumnInfo(name = "height") val height: String?,
    @ColumnInfo(name = "units") val units: String?,
    @ColumnInfo(name = "bmiValue") val bmiValue: String?
) : Serializable {
    override fun toString(): String {
        return "BmiResult(date='$date', weight='$weight', height='$height', units='$units', bmiValue='$bmiValue')"
    }

    fun setId(id: Int){
        this.id = id
    }

    fun getId(): Int{
        return this.id
    }
}
