package com.dhikra.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhikra.app.domain.model.Prayer
import com.dhikra.app.domain.model.PrayerTimes
import com.dhikra.app.domain.repository.PrayerTimesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PrayerViewModel(
    private val prayerTimesRepository: PrayerTimesRepository
) : ViewModel() {

    private val _prayerTimes = MutableStateFlow<PrayerTimes?>(null)
    val prayerTimes: StateFlow<PrayerTimes?> = _prayerTimes.asStateFlow()

    private val _nextPrayer = MutableStateFlow<Prayer?>(null)
    val nextPrayer: StateFlow<Prayer?> = _nextPrayer.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun loadPrayerTimes(latitude: Double, longitude: Double, method: String = "Umm Al-Qura") {
        viewModelScope.launch {
            _isLoading.value = true
            val result = prayerTimesRepository.getPrayerTimes(latitude, longitude, method)
            result.onSuccess { times ->
                _prayerTimes.value = times
                _nextPrayer.value = prayerTimesRepository.getNextPrayer(times)
                _isLoading.value = false
            }
            result.onFailure { exception ->
                _error.value = exception.message
                _isLoading.value = false
            }
        }
    }

    fun loadPrayerTimesForCity(city: String, method: String = "Umm Al-Qura") {
        viewModelScope.launch {
            _isLoading.value = true
            val result = prayerTimesRepository.getPrayerTimesForCity(city, method)
            result.onSuccess { times ->
                _prayerTimes.value = times
                _nextPrayer.value = prayerTimesRepository.getNextPrayer(times)
                _isLoading.value = false
            }
            result.onFailure { exception ->
                _error.value = exception.message
                _isLoading.value = false
            }
        }
    }
}
