package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bmi.models.BmiHistoryRepository
import com.example.bmi.models.BmiResult
import kotlinx.android.synthetic.main.activity_bmi_history.*

class BmiHistory : AppCompatActivity() {
    private lateinit var bmiAdapter: BmiHistoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_history)
        val myHistory = BmiHistoryRepository(application).getHistory()
        initRecyclerView()
        addDataSet(myHistory as ArrayList<BmiResult>)
    }

    private fun addDataSet(dataList: ArrayList<BmiResult>){
        bmiAdapter.submitList(dataList)
    }

    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@BmiHistory)
            bmiAdapter = BmiHistoryRecyclerAdapter()
            recycler_view.adapter = bmiAdapter
        }
    }
}
