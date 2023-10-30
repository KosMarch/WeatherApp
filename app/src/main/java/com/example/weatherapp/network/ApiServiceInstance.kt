package com.example.weatherapp.network

import com.example.weatherapp.WeatherConstant.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceInstance {
    private var service: WeatherApiService? = null

    fun getApiService(): WeatherApiService {
        if (service == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            service = retrofit.create(WeatherApiService::class.java)
        }
        return service!!
    }
}