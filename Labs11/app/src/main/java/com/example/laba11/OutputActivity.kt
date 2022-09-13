package com.example.laba11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class OutputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)
        val file = assets.open("weather.json")
        val  builder = StringBuilder()
        var b = file.read()
        while (b != -1){
            builder.append(b.toChar())
            b=file.read()
        }
        val json = builder.toString()
        val weather: List<Weather> = Gson().fromJson<List<Weather>>(json, object : TypeToken<List<Weather>>(){}.type)
        Log.d("yy", weather.toString())

    }
}