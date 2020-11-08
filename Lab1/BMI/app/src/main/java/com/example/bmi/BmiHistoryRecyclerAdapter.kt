package com.example.bmi

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bmi.models.BmiResult
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bmi_history_row.view.*

class BmiHistoryRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: List<BmiResult> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.bmi_history_row, parent, false)
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BlogViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<BmiResult>){
        items = blogList
    }


    class BlogViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val historyDate = itemView.TV_Bmi_history_date
        val historyWeight = itemView.TV_Bmi_history_weight
        val historyHeight = itemView.TV_Bmi_history_height
        val historyBmi = itemView.TV_Bmi_history_bmi
        val historyBmiDisplay = itemView.CV_Bmi_hisotry_bmi_display
        val historyImage = itemView.IV_Bmi_hisotry_image

        @SuppressLint("SetTextI18n")
        fun bind(bmiResult: BmiResult){
            val historyWeightUnit = if (bmiResult.units == "cm/kg") "kg" else if (bmiResult.units == "in/lbs") "lbs" else " "
            val historyHeightUnit = if (bmiResult.units == "cm/kg") "cm" else if (bmiResult.units == "in/lbs") "in" else " "
            val bmiColor = colorBmiText(bmiResult.bmiValue)
            chooseBmiImage(bmiResult.bmiValue)
            historyDate.setText((bmiResult.date.toString().replace("T"," ")))
            historyWeight.setText((bmiResult.weight) + historyWeightUnit)
            historyHeight.setText((bmiResult.height) + historyHeightUnit)
            historyBmi.setText(bmiResult.bmiValue)
            historyBmi.setTextColor(Color.parseColor(bmiColor))

        }

        fun colorBmiText(value: String): String {
            val bmiValue: Double = value.toString().replace(",",".").toDouble()
            if (bmiValue < 16) return "#add8d1"
            if (bmiValue > 16 && bmiValue < 16.99) return "#76a69e"
            if (bmiValue > 17 && bmiValue < 18.49) return "#7690c9"
            if (bmiValue > 18.5 && bmiValue < 24.99) return "#a3e257"
            if (bmiValue > 25 && bmiValue < 29.99) return "#fdd21c"
            if (bmiValue > 30 && bmiValue < 34.99) return "#f88b3b"
            if (bmiValue > 35 && bmiValue < 39.99) return "#f07882"
            if (bmiValue > 40) return "#e31e24"
            return "#000000"
        }

        fun chooseBmiImage(value: String){
            val bmiValue: Double = value.toString().replace(",",".").toDouble()
            if (bmiValue < 16.99) historyImage.setImageResource(R.drawable.poziom_1)
            if (bmiValue > 17 && bmiValue < 18.49) historyImage.setImageResource(R.drawable.poziom_2)
            if (bmiValue > 18.5 && bmiValue < 24.99) historyImage.setImageResource(R.drawable.poziom_3)
            if (bmiValue > 25 && bmiValue < 29.99) historyImage.setImageResource(R.drawable.poziom_4)
            if (bmiValue > 30 && bmiValue < 34.99) historyImage.setImageResource(R.drawable.poziom_5)
            if (bmiValue > 35) historyImage.setImageResource(R.drawable.poziom_6)
        }
    }

}