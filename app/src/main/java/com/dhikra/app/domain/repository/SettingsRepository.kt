package com.dhikra.app.domain.repository

import com.dhikra.app.domain.model.UserSettings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getUserSettings(userId: String): Flow<UserSettings?>
    suspend fun insertSettings(settings: UserSettings)
    suspend fun updateSettings(settings: UserSettings)
}
