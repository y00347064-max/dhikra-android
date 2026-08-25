package com.dhikra.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhikra.app.domain.model.Theme
import com.dhikra.app.domain.model.UserSettings
import com.dhikra.app.domain.repository.SettingsRepository
import com.dhikra.app.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val settingsRepository: SettingsRepository,
    private val themeRepository: ThemeRepository
) : ViewModel() {

    private val _settings = MutableStateFlow<UserSettings?>(null)
    val settings: StateFlow<UserSettings?> = _settings.asStateFlow()

    private val _themes = MutableStateFlow<List<Theme>>(emptyList())
    val themes: StateFlow<List<Theme>> = _themes.asStateFlow()

    private val _selectedTheme = MutableStateFlow<Theme?>(null)
    val selectedTheme: StateFlow<Theme?> = _selectedTheme.asStateFlow()

    fun loadSettings(userId: String) {
        viewModelScope.launch {
            settingsRepository.getUserSettings(userId).collect { settings ->
                _settings.value = settings
            }
        }
    }

    fun loadThemes() {
        viewModelScope.launch {
            themeRepository.getAllThemes().collect { themes ->
                _themes.value = themes
            }
        }
    }

    fun selectTheme(themeId: String) {
        viewModelScope.launch {
            themeRepository.selectTheme(themeId)
            themeRepository.getSelectedTheme().collect { theme ->
                _selectedTheme.value = theme
            }
        }
    }

    fun updateSettings(settings: UserSettings) {
        viewModelScope.launch {
            settingsRepository.updateSettings(settings)
        }
    }
}
