package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_bmi_details.*

class BmiDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_details)

        val message = intent.getDoubleExtra(EXTRA_MESSAGE, 0.0)
        findViewById<TextView>(R.id.TV_Bmi_text).apply {
            text = message.toString()
        }
        matchContent(message)
    }

    private fun matchContent(bmiValue: Double){
        when {
            bmiValue < BmiRanges.verySeverlyUnderweightUpperLevel -> {
                IV_Bmi_image.setImageResource(R.drawable.level_1)
                TV_Bmi_Description.text = getString(R.string.bmi_16)
            }
            bmiValue >= BmiRanges.severelyUnderweightLowerLevel && bmiValue < BmiRanges.severelyUnderweightUpperLevel -> {
                IV_Bmi_image.setImageResource(R.drawable.level_1)
                TV_Bmi_Description.text = getString(R.string.bmi_16_17)
            }
            bmiValue >= BmiRanges.underweightLowerLevel && bmiValue < BmiRanges.underweightUpperLevel -> {
                IV_Bmi_image.setImageResource(R.drawable.level_2)
                TV_Bmi_Description.text = getString(R.string.bmi_17_185)
            }
            bmiValue >= BmiRanges.normalLowerLevel && bmiValue < BmiRanges.normalUpperLevel -> {
                IV_Bmi_image.setImageResource(R.drawable.level_3)
                TV_Bmi_Description.text = getString(R.string.bmi_185_25)
            }
            bmiValue >= BmiRanges.overweightLowerLevel && bmiValue < BmiRanges.overweightUpperLevel -> {
                IV_Bmi_image.setImageResource(R.drawable.level_4)
                TV_Bmi_Description.text = getString(R.string.bmi_25_30)
            }
            bmiValue >= BmiRanges.obeseClassILowerLevel && bmiValue < BmiRanges.obeseClassIUpperLevel -> {
                IV_Bmi_image.setImageResource(R.drawable.level_5)
                TV_Bmi_Description.text = getString(R.string.bmi_30_35)
            }
            bmiValue >= BmiRanges.obeseClassIILowerLevel && bmiValue < BmiRanges.obeseClassIIUpperLevel -> {
                IV_Bmi_image.setImageResource(R.drawable.level_6)
                TV_Bmi_Description.text = getString(R.string.bmi_35_40)
            }
            bmiValue >= BmiRanges.obeseClassIIILowerLevel -> {
                IV_Bmi_image.setImageResource(R.drawable.level_6)
                TV_Bmi_Description.text = getString(R.string.bmi_40)
            }
        }
    }
}
