package com.example.bmi

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bmi.models.BmiResult
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
                holder.bind(items[position])
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

        private val historyDate = itemView.TV_Bmi_history_date
        private val historyWeight = itemView.TV_Bmi_history_weight
        private val historyHeight = itemView.TV_Bmi_history_height
        private val historyBmi = itemView.TV_Bmi_history_bmi
        private val historyImage = itemView.IV_Bmi_hisotry_image

        @SuppressLint("SetTextI18n")
        fun bind(bmiResult: BmiResult){
            val historyWeightUnit = if (bmiResult.units == "cm/kg") "kg" else if (bmiResult.units == "in/lbs") "lbs" else " "
            val historyHeightUnit = if (bmiResult.units == "cm/kg") "cm" else if (bmiResult.units == "in/lbs") "in" else " "
            val bmiColor = bmiResult.bmiValue?.let { colorBmiText(it) }
            bmiResult.bmiValue?.let { chooseBmiImage(it) }
            historyDate.text = (bmiResult.date.toString().replace("T"," "))
            historyWeight.text = (bmiResult.weight) + historyWeightUnit
            historyHeight.text = (bmiResult.height) + historyHeightUnit
            historyBmi.text = bmiResult.bmiValue
            historyBmi.setTextColor(Color.parseColor(bmiColor))
        }

        private fun colorBmiText(value: String): String {
            val bmiValue: Double = value.toString().replace(",",".").toDouble()
            if (bmiValue < BmiRanges.verySeverlyUnderweightUpperLevel) return "#add8d1"
            else if (bmiValue >= BmiRanges.severelyUnderweightLowerLevel && bmiValue < BmiRanges.severelyUnderweightUpperLevel) return "#76a69e"
            else if (bmiValue >= BmiRanges.underweightLowerLevel && bmiValue < BmiRanges.underweightUpperLevel) return "#7690c9"
            else if (bmiValue >= BmiRanges.normalLowerLevel && bmiValue < BmiRanges.normalUpperLevel) return "#a3e257"
            else if (bmiValue >= BmiRanges.overweightLowerLevel && bmiValue < BmiRanges.overweightUpperLevel) return "#fdd21c"
            else if (bmiValue >= BmiRanges.obeseClassILowerLevel && bmiValue < BmiRanges.obeseClassIUpperLevel) return "#f88b3b"
            else if (bmiValue >= BmiRanges.obeseClassIILowerLevel && bmiValue < BmiRanges.obeseClassIIUpperLevel) return "#f07882"
            else if (bmiValue >= BmiRanges.obeseClassIIILowerLevel) return "#e31e24"
            return "#000000"
        }

        private fun chooseBmiImage(value: String){
            val bmiValue: Double = value.toString().replace(",",".").toDouble()
            if (bmiValue < BmiRanges.severelyUnderweightUpperLevel) historyImage.setImageResource(R.drawable.level_1)
            if (bmiValue >= BmiRanges.underweightLowerLevel && bmiValue < BmiRanges.underweightUpperLevel) historyImage.setImageResource(R.drawable.level_2)
            if (bmiValue >= BmiRanges.normalLowerLevel && bmiValue < BmiRanges.normalUpperLevel) historyImage.setImageResource(R.drawable.level_3)
            if (bmiValue >= BmiRanges.overweightLowerLevel && bmiValue < BmiRanges.overweightUpperLevel) historyImage.setImageResource(R.drawable.level_4)
            if (bmiValue >= BmiRanges.obeseClassILowerLevel && bmiValue < BmiRanges.obeseClassIUpperLevel) historyImage.setImageResource(R.drawable.level_5)
            if (bmiValue >= BmiRanges.obeseClassIILowerLevel) historyImage.setImageResource(R.drawable.level_6)
        }
    }
}
