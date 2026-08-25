package com.dhikra.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhikra.app.domain.model.Surah
import com.dhikra.app.domain.repository.SurahRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuranViewModel(
    private val surahRepository: SurahRepository
) : ViewModel() {

    private val _surahs = MutableStateFlow<List<Surah>>(emptyList())
    val surahs: StateFlow<List<Surah>> = _surahs.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadSurahs()
    }

    private fun loadSurahs() {
        viewModelScope.launch {
            _isLoading.value = true
            surahRepository.getAllSurahs().collect { surahs ->
                _surahs.value = surahs
                _isLoading.value = false
            }
        }
    }

    fun searchSurahs(query: String) {
        viewModelScope.launch {
            surahRepository.searchSurahs(query).collect { results ->
                _surahs.value = results
            }
        }
    }

    fun updateLastReadAyah(surahNumber: Int, ayahNumber: Int) {
        viewModelScope.launch {
            surahRepository.updateLastReadAyah(surahNumber, ayahNumber)
        }
    }
}
