package com.example.bmi.models

import android.app.Application

class BmiHistoryRepository(application: Application) {
    private var historyDao: BmiHistoryDao
    private var measurements: List<BmiResult>

    init {
        val database: BmiHistoryDatabase = BmiHistoryDatabase.getInstance(application)
        historyDao = database.bmiHistoryDao()
        measurements = historyDao.getHistory()
    }

    fun insert(dataHolder: BmiResult) {
        historyDao.insert(dataHolder)
    }

    fun getHistory(): List<BmiResult> {
        return measurements
    }
}
