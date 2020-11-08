package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bmi.models.BmiResult
import kotlinx.android.synthetic.main.activity_bmi_history.*

class BmiHistory : AppCompatActivity() {

    private lateinit var blogAdapter: BmiHistoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_history)
        val myDataSet = intent.getSerializableExtra(EXTRA_MESSAGE)
        initRecyclerView()
        addDataSet(myDataSet as ArrayList<BmiResult>)
    }

    private fun addDataSet(dataList: ArrayList<BmiResult>){
        blogAdapter.submitList(dataList)
    }

    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@BmiHistory)
            blogAdapter = BmiHistoryRecyclerAdapter()
            recycler_view.adapter = blogAdapter
        }
    }

}