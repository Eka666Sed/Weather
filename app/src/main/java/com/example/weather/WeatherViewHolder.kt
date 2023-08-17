package com.example.weather

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class WeatherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val rootLayout: LinearLayout = itemView.findViewById(R.id.rootLayout)
    private val tvDay: TextView = itemView.findViewById(R.id.tvDay)
    private val ivClouds: ImageView = itemView.findViewById(R.id.ivClouds)
    private val tvTemperature: TextView = itemView.findViewById(R.id.tvTemperature)

    fun bind(item: DailyWeather) {
        val temp = item.temperature
        val tempString =
            if (temp > 0) R.string.plus_temperature
           else R.string.minus_temperature
        val tempColor = when {
            temp < -20 -> R.color.less_then_minus_20
            temp in -20..-15 -> R.color.minus_20_to_minus_15
            temp in -14..-10 -> R.color.minus_14_to_minus_10
           // temp in -9..9 -> R.color.minus_9_to_plus_9
            temp in 10..14 -> R.color.plus_10_to_plus_14
            temp in 15..20 -> R.color.plus_15_to_plus_20
            else -> R.color.more_then_plus_20

        }

        val cloudsIcon = if (item.clouds) R.drawable.ic_cloud else R.drawable.ic_sun

        tvDay.text = item.day
        ivClouds.setImageResource(cloudsIcon)
        tvTemperature.text = itemView.context.getString(tempString, temp)
        rootLayout.setBackgroundColor(itemView.context.getColor(tempColor))
    }
}