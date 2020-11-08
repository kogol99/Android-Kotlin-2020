package com.example.bmi

class BmiLbInc(var height: Double, var mass: Double): Bmi{
    override fun count(): Double {
        if (height > 100 || height < 40) return -1.0
        if (mass > 330 || mass < 66) return -1.0
        return (mass / (height * height)) * 703
    }
}