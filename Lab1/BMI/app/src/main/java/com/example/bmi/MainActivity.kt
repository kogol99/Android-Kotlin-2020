package com.example.bmi

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.example.bmi.databinding.ActivityMainBinding
import com.example.bmi.models.BmiHistoryRepository
import com.example.bmi.models.BmiResult
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime

const val EXTRA_MESSAGE = "MESSAGE"

class MainActivity : AppCompatActivity() {
    private lateinit var bmiHistoryRepository: BmiHistoryRepository
    lateinit var binding: ActivityMainBinding
    var isCmKgUnits: Boolean = true
    var bmiCount: Double = 0.0
    var bmiHistoryList = ArrayList<BmiResult>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bmiHistoryRepository = BmiHistoryRepository(application)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("BMI_result", bmiTV.text.toString())
        outState.putString("mass_text", massTV.text.toString())
        outState.putString("height_text", heightTV.text.toString())
        outState.putBoolean("unit_info", isCmKgUnits)
        val color = bmiTV.currentTextColor
        outState.putInt("BMI_color", color)
        outState.putSerializable("BMI_history", bmiHistoryList)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        bmiTV.text = savedInstanceState.getString("BMI_result")
        massTV.text = savedInstanceState.getString("mass_text")
        heightTV.text = savedInstanceState.getString("height_text")
        isCmKgUnits = savedInstanceState.getBoolean("unit_info")
        bmiTV.setTextColor(savedInstanceState.getInt("BMI_color"))
        bmiHistoryList = savedInstanceState.getSerializable("BMI_history") as ArrayList<BmiResult>
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.change_units, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.cm_kg -> {
                changeToCmKg()
                true
            }
            R.id.in_lbs -> {
                changeToInLbs()
                true
            }
            R.id.history -> {
                openBmiHistory()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun changeToCmKg() {
        isCmKgUnits = true
        massTV.text = getString(R.string.mass_kg)
        heightTV.text = getString(R.string.height_cm)
    }

    private fun changeToInLbs() {
        isCmKgUnits = false
        massTV.text = getString(R.string.mass_lb)
        heightTV.text = getString(R.string.height_inc)
    }

    fun count(view: View) {
        binding.apply {
            var isGood: Boolean = true;
            if (heightET.text.isBlank()) {
                heightET.error = getString(R.string.height_is_empty)
                isGood = false
            }
            else if (isCmKgUnits) {
                if (heightET.text.toString().toDouble() < 100 || heightET.text.toString().toDouble() > 250) {
                    heightET.error = getString(R.string.height_range_cm)
                    isGood = false
                }
            }
            else if (!isCmKgUnits) {
                if (heightET.text.toString().toDouble() < 40 || heightET.text.toString().toDouble() > 100) {
                    heightET.error = getString(R.string.height_range_in)
                    isGood = false
                }
            }
            if (massET.text.isBlank()) {
                massET.error = getString(R.string.mass_is_empty)
                isGood = false
            }
            else if (isCmKgUnits) {
                if (massET.text.toString().toDouble() < 30 || massET.text.toString().toDouble() > 150) {
                    massET.error = getString(R.string.mass_range_kg)
                    isGood = false
                }
            }
            else if (!isCmKgUnits) {
                if (massET.text.toString().toDouble() < 66 || massET.text.toString().toDouble() > 330) {
                    massET.error = getString(R.string.mass_range_lb)
                    isGood = false
                }
            }

            if (isGood) {
                val bmiProgram: Bmi = if (isCmKgUnits){
                    BmiKgCm(heightET.text.toString().toDouble(), massET.text.toString().toDouble())
                } else {
                    BmiLbInc(heightET.text.toString().toDouble(), massET.text.toString().toDouble())
                }

                bmiCount = bmiProgram.count()
                bmiTV.text = String.format("%.2f", bmiCount.toString().replace(",",".").toDouble())
                colorBmiText()
                addToHistoryList()
            }
        }
    }

    private fun colorBmiText() {
        val bmiValue: Double = bmiTV.text.toString().replace(",",".").toDouble()
        if (bmiValue < BmiRanges.verySeverlyUnderweightUpperLevel) bmiTV.setTextColor(Color.parseColor("#add8d1"))
        if (bmiValue >= BmiRanges.severelyUnderweightLowerLevel && bmiValue < BmiRanges.severelyUnderweightUpperLevel) bmiTV.setTextColor(Color.parseColor("#76a69e"))
        if (bmiValue >= BmiRanges.underweightLowerLevel && bmiValue < BmiRanges.underweightUpperLevel) bmiTV.setTextColor(Color.parseColor("#7690c9"))
        if (bmiValue >= BmiRanges.normalLowerLevel && bmiValue < BmiRanges.normalUpperLevel) bmiTV.setTextColor(Color.parseColor("#a3e257"))
        if (bmiValue >= BmiRanges.overweightLowerLevel && bmiValue < BmiRanges.overweightUpperLevel) bmiTV.setTextColor(Color.parseColor("#fdd21c"))
        if (bmiValue >= BmiRanges.obeseClassILowerLevel && bmiValue < BmiRanges.obeseClassIUpperLevel) bmiTV.setTextColor(Color.parseColor("#f88b3b"))
        if (bmiValue >= BmiRanges.obeseClassIILowerLevel && bmiValue < BmiRanges.obeseClassIIUpperLevel) bmiTV.setTextColor(Color.parseColor("#f07882"))
        if (bmiValue >= BmiRanges.obeseClassIIILowerLevel) bmiTV.setTextColor(Color.parseColor("#e31e24"))
    }

    private fun addToHistoryList() {
        val currentDateTime = LocalDateTime.now()
        val newHistoryObject =
            BmiResult(
                date = currentDateTime.toString(),
                weight = massET.text.toString(),
                height = heightET.text.toString(),
                units = if(isCmKgUnits) "cm/kg" else "in/lbs",
                bmiValue = bmiTV.text.toString()
            )
        bmiHistoryRepository.insert(newHistoryObject)
    }

    fun openBmiDetails(view: View){
        if (bmiTV.text.toString().replace(",", ".") != "0.00") {
            val message = bmiTV.text.toString().replace(",", ".").toDouble()
            val bmiColor = bmiTV.currentTextColor.toString()
            val intent = Intent(this, BmiDetails::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)
            }
            startActivityForResult(intent, 0)
        }
    }

    private fun openBmiHistory(){
        val intent = Intent(this, BmiHistory::class.java).apply {
            putExtra(EXTRA_MESSAGE, bmiHistoryList)
        }
        startActivityForResult(intent, 0)
    }
}
