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
        val textView = findViewById<TextView>(R.id.TV_Bmi_text).apply {
            text = message.toString()
        }
        matchContent(message)
    }

    private fun matchContent(bmiValue: Double){
        when {
            bmiValue < 16 -> {
                IV_Bmi_image.setImageResource(R.drawable.poziom_1)
                TV_Bmi_Description.text = getString(R.string.bmi_16)
            }
            bmiValue >= 16 && bmiValue < 17 -> {
                IV_Bmi_image.setImageResource(R.drawable.poziom_1)
                TV_Bmi_Description.text = getString(R.string.bmi_16_17)
            }
            bmiValue >= 17 && bmiValue < 18.5 -> {
                IV_Bmi_image.setImageResource(R.drawable.poziom_2)
                TV_Bmi_Description.text = getString(R.string.bmi_17_185)
            }
            bmiValue >= 18.5 && bmiValue < 25 -> {
                IV_Bmi_image.setImageResource(R.drawable.poziom_3)
                TV_Bmi_Description.text = getString(R.string.bmi_185_25)
            }
            bmiValue >= 25 && bmiValue < 30 -> {
                IV_Bmi_image.setImageResource(R.drawable.poziom_4)
                TV_Bmi_Description.text = getString(R.string.bmi_25_30)
            }
            bmiValue >= 30 && bmiValue < 35 -> {
                IV_Bmi_image.setImageResource(R.drawable.poziom_5)
                TV_Bmi_Description.text = getString(R.string.bmi_30_35)
            }
            bmiValue >= 35 && bmiValue < 40 -> {
                IV_Bmi_image.setImageResource(R.drawable.poziom_6)
                TV_Bmi_Description.text = getString(R.string.bmi_35_40)
            }
            bmiValue >= 40 -> {
                IV_Bmi_image.setImageResource(R.drawable.poziom_6)
                TV_Bmi_Description.text = getString(R.string.bmi_40)
            }
        }
    }
}