package com.example.weatherapp.network

data class WeatherForecastDay(
    val date: String,
    val day: WeatherDay,
    val hour: List<WeatherHour>
)