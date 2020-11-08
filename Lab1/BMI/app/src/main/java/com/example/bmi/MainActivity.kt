package com.example.bmi

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.example.bmi.databinding.ActivityMainBinding
import com.example.bmi.models.BmiResult
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var is_cm_kg_units: Boolean = true
    var bmiCount: Double = 0.0
    var bmiHistoryList = ArrayList<BmiResult>()

    private lateinit var sharedPrefHistory: SharedPreferences
    private val historyPrefKey = "History"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        sharedPrefHistory = getPreferences(Context.MODE_PRIVATE)
        loadPref()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("BMI_result", bmiTV.text.toString())
        outState.putString("mass_text", massTV.text.toString())
        outState.putString("height_text", heightTV.text.toString())
        outState.putBoolean("unit_info", is_cm_kg_units)
        val color = bmiTV.currentTextColor
        outState.putInt("BMI_color", color)
        outState.putSerializable("BMI_history", bmiHistoryList)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        bmiTV.text = savedInstanceState.getString("BMI_result")
        massTV.text = savedInstanceState.getString("mass_text")
        heightTV.text = savedInstanceState.getString("height_text")
        is_cm_kg_units = savedInstanceState.getBoolean("unit_info")
        bmiTV.setTextColor(savedInstanceState.getInt("BMI_color"))
        bmiHistoryList = savedInstanceState.getSerializable("BMI_history") as ArrayList<BmiResult>
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.change_units, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
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
        is_cm_kg_units = true
        massTV.text = getString(R.string.mass_kg)
        heightTV.text = getString(R.string.height_cm)
    }

    private fun changeToInLbs() {
        is_cm_kg_units = false
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
            else if (is_cm_kg_units) {
                if (heightET.text.toString().toDouble() < 100 || heightET.text.toString().toDouble() > 250) {
                    heightET.error = getString(R.string.height_range_cm)
                    isGood = false
                }
            }
            else if (!is_cm_kg_units) {
                if (heightET.text.toString().toDouble() < 40 || heightET.text.toString().toDouble() > 100) {
                    heightET.error = getString(R.string.height_range_in)
                    isGood = false
                }
            }
            if (massET.text.isBlank()) {
                massET.error = getString(R.string.mass_is_empty)
                isGood = false
            }
            else if (is_cm_kg_units) {
                if (massET.text.toString().toDouble() < 30 || massET.text.toString().toDouble() > 150) {
                    massET.error = getString(R.string.mass_range_kg)
                    isGood = false
                }
            }
            else if (!is_cm_kg_units) {
                if (massET.text.toString().toDouble() < 66 || massET.text.toString().toDouble() > 330) {
                    massET.error = getString(R.string.mass_range_lb)
                    isGood = false
                }
            }

            if (isGood) {
                val bmiProgram: Bmi;
                if (is_cm_kg_units){
                    bmiProgram = BmiKgCm(heightET.text.toString().toDouble(), massET.text.toString().toDouble())
                }
                else {
                    bmiProgram = BmiLbInc(heightET.text.toString().toDouble(), massET.text.toString().toDouble())
                }

                bmiCount = bmiProgram.count()
                bmiTV.text = String.format("%.2f", bmiCount.toString().replace(",",".").toDouble())
                colorBmiText()
                if (bmiHistoryList.size >= 10) {
                    bmiHistoryList.removeAt(0)
                    addToHistoryList()
                } else {
                    addToHistoryList()
                }
            }
        }
    }

    fun colorBmiText() {
        val bmiValue: Double = bmiTV.text.toString().replace(",",".").toDouble()
        if (bmiValue < 16) bmiTV.setTextColor(Color.parseColor("#add8d1"))
        if (bmiValue > 16 && bmiValue < 16.99) bmiTV.setTextColor(Color.parseColor("#76a69e"))
        if (bmiValue > 17 && bmiValue < 18.49) bmiTV.setTextColor(Color.parseColor("#7690c9"))
        if (bmiValue > 18.5 && bmiValue < 24.99) bmiTV.setTextColor(Color.parseColor("#a3e257"))
        if (bmiValue > 25 && bmiValue < 29.99) bmiTV.setTextColor(Color.parseColor("#fdd21c"))
        if (bmiValue > 30 && bmiValue < 34.99) bmiTV.setTextColor(Color.parseColor("#f88b3b"))
        if (bmiValue > 35 && bmiValue < 39.99) bmiTV.setTextColor(Color.parseColor("#f07882"))
        if (bmiValue > 40) bmiTV.setTextColor(Color.parseColor("#e31e24"))
    }

    fun addToHistoryList() {
        val currentDateTime = LocalDateTime.now()
        bmiHistoryList.add(
            BmiResult(
                currentDateTime.toString(),
                massET.text.toString(),
                heightET.text.toString(),
                if(is_cm_kg_units) "cm/kg" else "in/lbs",
                bmiTV.text.toString()
            )
        )
        saveToPref()
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

    fun openBmiHistory(){
        val intent = Intent(this, BmiHistory::class.java).apply {
            putExtra(EXTRA_MESSAGE, bmiHistoryList)
        }
        startActivityForResult(intent, 0)
    }

    private fun saveToPref(){
        val editor: SharedPreferences.Editor = sharedPrefHistory.edit()
        val gson: Gson = Gson()
        var json: String = gson.toJson(bmiHistoryList)
        editor.putString("data_list",json)
        editor.apply()
    }

    private fun loadPref(){
        val json = sharedPrefHistory.getString("data_list", null)
        val type = object : TypeToken<ArrayList<BmiResult>>(){}.type
        if (json == null) {
            bmiHistoryList = ArrayList<BmiResult>()
        }
        else{
            bmiHistoryList = Gson().fromJson(json, type)
        }
    }
}