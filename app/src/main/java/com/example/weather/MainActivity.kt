package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherAdapter = WeatherAdapter(
            listOf(
                DailyWeather("Пн", true, -23),
                DailyWeather("Вт", true, -20),
                DailyWeather("Ср", true, -15),
                DailyWeather("Чт", true, -3),
                DailyWeather("Пт", false, +6),
                DailyWeather("Сб", false, +11),
                DailyWeather("Вс", false, +20),
            )
        )

        val rvWeather = findViewById<RecyclerView>(R.id.rvWeather)
        rvWeather.adapter = weatherAdapter

    }
}