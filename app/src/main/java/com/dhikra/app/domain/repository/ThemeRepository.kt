package com.dhikra.app.domain.repository

import com.dhikra.app.domain.model.Theme
import kotlinx.coroutines.flow.Flow

interface ThemeRepository {
    fun getAllThemes(): Flow<List<Theme>>
    fun getFreeThemes(): Flow<List<Theme>>
    fun getPremiumThemes(): Flow<List<Theme>>
    fun getSelectedTheme(): Flow<Theme?>
    suspend fun insertThemes(themes: List<Theme>)
    suspend fun selectTheme(themeId: String)
}
