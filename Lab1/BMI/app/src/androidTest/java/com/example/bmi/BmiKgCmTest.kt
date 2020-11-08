package com.example.bmi

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe

class BmiKgCmTest : FunSpec({

    test("testing bmi count for 50/150 kg/cm") {
        BmiKgCm(150.0, 50.0).count() shouldBe (22.22 plusOrMinus 0.01)
    }
    test("testing bmi count for 75/160 kg/cm") {
        BmiKgCm(160.0,75.0).count() shouldBe(29.30 plusOrMinus 0.01)
    }
    test("testing bmi count for 71/190 kg/cm") {
        BmiKgCm(190.0,71.0).count() shouldBe(19.67 plusOrMinus 0.01)
    }
    test("testing bmi count for 87/158 kg/cm") {
        BmiKgCm(158.0,87.0).count() shouldBe(34.85 plusOrMinus 0.01)
    }
    test("testing bmi count for 95/194 kg/cm") {
        BmiKgCm(194.0,95.0).count() shouldBe(25.24 plusOrMinus 0.01)
    }
    test("testing bmi count for 95/195 kg/cm") {
        BmiKgCm(195.0,95.0).count() shouldBe(24.98 plusOrMinus 0.01)
    }
    test("testing bmi count for 73/210 kg/cm") {
        BmiKgCm(210.0,73.0).count() shouldBe(16.55 plusOrMinus 0.01)
    }
    test("testing none bmi count for 50/251 kg/cm") {
        BmiKgCm(251.0, 50.0).count() shouldBe -1.0
    }
    test("testing none bmi count for 50/99 kg/cm") {
        BmiKgCm(99.0, 50.0).count() shouldBe -1.0
    }
    test("testing none bmi count for 29/150 kg/cm") {
        BmiKgCm(150.0, 29.0).count() shouldBe -1.0
    }
    test("testing none bmi count for 151/150 kg/cm") {
        BmiKgCm(150.0, 151.0).count() shouldBe -1.0
    }
    test("testing none bmi count for 25/251 kg/cm") {
        BmiKgCm(251.0, 25.0).count() shouldBe -1.0
    }
    test("testing none bmi count for 330/92 kg/cm") {
        BmiKgCm(92.0, 330.0).count() shouldBe -1.0
    }
    test("testing none bmi count for 5/5 kg/cm") {
        BmiKgCm(5.0, 5.0).count() shouldBe -1.0
    }
})
