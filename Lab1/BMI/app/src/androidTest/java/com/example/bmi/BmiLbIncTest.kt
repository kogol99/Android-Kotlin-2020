package com.example.bmi

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe

class BmiLbIncTest : FunSpec({
    test("testing bmi count for 50/150 lb/inc") {
        BmiLbInc(95.0, 240.0).count() shouldBe (18.69 plusOrMinus 0.01)
    }
    test("testing bmi count for 75/160 lb/inc") {
        BmiLbInc(84.0,98.0).count() shouldBe(9.76 plusOrMinus 0.01)
    }
    test("testing bmi count for 71/190 lb/inc") {
        BmiLbInc(45.0,69.0).count() shouldBe(23.95 plusOrMinus 0.01)
    }
    test("testing bmi count for 87/158 lb/inc") {
        BmiLbInc(45.0,100.0).count() shouldBe(34.72 plusOrMinus 0.01)
    }
    test("testing bmi count for 95/194 lb/inc") {
        BmiLbInc(74.0,174.0).count() shouldBe(22.34 plusOrMinus 0.01)
    }
    test("testing bmi count for 150/90 lb/inc") {
        BmiLbInc(90.0,150.0).count() shouldBe(13.02 plusOrMinus 0.01)
    }
    test("testing bmi count for 200/50 lb/inc") {
        BmiLbInc(50.0,200.0).count() shouldBe(56.24 plusOrMinus 0.01)
    }
    test("testing none bmi count for 65/70 lb/inc") {
        BmiLbInc(70.0, 65.0).count() shouldBe -1.0
    }
    test("testing none bmi count for 351/70 lb/inc") {
        BmiLbInc(70.0, 331.0).count() shouldBe -1.0
    }
    test("testing none bmi count for 200/101 lb/inc") {
        BmiLbInc(101.0, 200.0).count() shouldBe -1.0
    }
    test("testing none bmi count for 200/39 lb/inc") {
        BmiLbInc(39.0, 200.0).count() shouldBe -1.0
    }
    test("testing none bmi count for 20/101 lb/inc") {
        BmiLbInc(101.0, 20.0).count() shouldBe -1.0
    }
    test("testing none bmi count for 358/20 lb/inc") {
        BmiLbInc(20.0, 358.0).count() shouldBe -1.0
    }
    test("testing none bmi count for 5/5 lb/inc") {
        BmiLbInc(5.0, 5.0).count() shouldBe -1.0
    }
})
