package com.example.bmi

class BmiKgCm(var height: Double, var mass: Double): Bmi{
    override fun count(): Double {
        if (height > 250 || height < 100) return -1.0
        if (mass > 150 || mass < 30) return -1.0
        height /= 100;
        return mass / (height * height)
    }
}
