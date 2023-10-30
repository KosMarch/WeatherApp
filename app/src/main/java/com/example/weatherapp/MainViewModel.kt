package com.example.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.network.RetrofitImpl
import com.example.weatherapp.network.WeatherResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val retrofitImpl = RetrofitImpl()

    private val _currentResponse = MutableLiveData<WeatherResponse>()
    val currentResponse: LiveData<WeatherResponse>
        get() = _currentResponse

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun updateWeather(city: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                _currentResponse.value = retrofitImpl.getWeather(city)
            } catch (e: Exception) {
                _errorMessage.value = "Error receiving data: ${e.message}"
            }
        }
    }
}