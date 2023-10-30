package com.example.weatherapp.network

data class WeatherCurrent(
    val last_updated: String,
    val temp_c: String,
    val condition: WeatherCondition
)