package com.example.weatherapp.network

data class WeatherHour(
    val time: String,
    val condition: WeatherCondition,
    val temp_c: String
)