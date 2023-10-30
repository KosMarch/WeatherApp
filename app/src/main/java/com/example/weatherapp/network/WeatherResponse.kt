package com.example.weatherapp.network

data class WeatherResponse(
    val location: WeatherLocation,
    val current: WeatherCurrent,
    val forecast: WeatherForecast
)