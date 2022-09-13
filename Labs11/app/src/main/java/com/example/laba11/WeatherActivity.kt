package com.example.laba11

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.gson.Gson

private lateinit var DateTime: EditText
private lateinit var Daytime_Temperature: EditText
private lateinit var NightTemp: EditText
private lateinit var btn: Button
class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        DateTime = findViewById(R.id.editTextTextPersonName)
        Daytime_Temperature = findViewById(R.id.editTextTextPersonName2)
        NightTemp = findViewById(R.id.editTextTextPersonName3)
        btn = findViewById(R.id.button3)
        var dateTime : String = DateTime.text.toString()
        var daytimeTemperature : String = Daytime_Temperature.text.toString()
        var nightTemp : String = NightTemp.text.toString()
        val mPrefs = getPreferences(MODE_PRIVATE)
        val nums : List<String> = listOf(dateTime, daytimeTemperature, nightTemp)
        btn.setOnClickListener {
            val prefsEditor: SharedPreferences.Editor = mPrefs.edit()
            val gson = Gson()
            val json = gson.toJson(nums)
            prefsEditor.putString("MyObject", json)
            prefsEditor.apply()
        }
    }
}