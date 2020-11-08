package com.example.bmi.models

import java.io.Serializable

class BmiResult(
    var date: String,
    var weight: String,
    var height: String,
    var units: String,
    var bmiValue: String
) : Serializable {
    override fun toString(): String {
        return "BlogPost(date='$date', weight='$weight', height='$height', units='$units', bmiValue='$bmiValue')"
    }
}