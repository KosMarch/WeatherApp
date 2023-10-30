package com.example.weatherapp.network

import com.example.weatherapp.WeatherConstant.ALERTS
import com.example.weatherapp.WeatherConstant.API_KEY
import com.example.weatherapp.WeatherConstant.AQI
import com.example.weatherapp.WeatherConstant.DAYS
import com.example.weatherapp.network.ApiServiceInstance.getApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RetrofitImpl {
    suspend fun getWeather(city: String): WeatherResponse {
        return withContext(Dispatchers.IO) {
            getApiService().getWeatherByCity(
                API_KEY,
                city,
                DAYS,
                AQI,
                ALERTS
            )
        }
    }
}