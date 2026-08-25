package com.dhikra.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhikra.app.domain.model.Tasbih
import com.dhikra.app.domain.repository.TasbihRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class TasbihViewModel(
    private val tasbihRepository: TasbihRepository
) : ViewModel() {

    private val _todayCount = MutableStateFlow<Tasbih?>(null)
    val todayCount: StateFlow<Tasbih?> = _todayCount.asStateFlow()

    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter.asStateFlow()

    init {
        loadTodayCount()
    }

    private fun loadTodayCount() {
        viewModelScope.launch {
            tasbihRepository.getTodayCount().collect { tasbih ->
                _todayCount.value = tasbih ?: Tasbih(
                    date = LocalDate.now().toString(),
                    totalCount = 0,
                    dailyGoal = 100
                )
                _counter.value = tasbih?.totalCount ?: 0
            }
        }
    }

    fun incrementCounter() {
        val newCount = _counter.value + 1
        _counter.value = newCount
        updateTodayCount(newCount)
    }

    fun resetCounter() {
        _counter.value = 0
        updateTodayCount(0)
    }

    private fun updateTodayCount(count: Int) {
        viewModelScope.launch {
            val current = _todayCount.value ?: Tasbih(
                date = LocalDate.now().toString(),
                totalCount = 0
            )
            val updated = current.copy(totalCount = count)
            tasbihRepository.updateCount(updated)
        }
    }
}
