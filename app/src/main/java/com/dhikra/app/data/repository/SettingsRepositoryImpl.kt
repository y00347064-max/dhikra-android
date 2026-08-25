package com.dhikra.app.data.repository

import com.dhikra.app.data.local.UserSettingsDao
import com.dhikra.app.data.local.entity.UserSettingsEntity
import com.dhikra.app.domain.model.UserSettings
import com.dhikra.app.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsRepositoryImpl(
    private val settingsDao: UserSettingsDao
) : SettingsRepository {

    override fun getUserSettings(userId: String): Flow<UserSettings?> =
        settingsDao.getUserSettings(userId).map { entity ->
            entity?.toDomain()
        }

    override suspend fun insertSettings(settings: UserSettings) {
        settingsDao.insertSettings(settings.toEntity())
    }

    override suspend fun updateSettings(settings: UserSettings) {
        settingsDao.updateSettings(settings.toEntity())
    }

    private fun UserSettingsEntity.toDomain() = UserSettings(
        userId = userId,
        language = language,
        isDarkMode = isDarkMode,
        country = country,
        city = city,
        timezone = timezone,
        prayerCalculationMethod = prayerCalculationMethod,
        madhab = madhab,
        enableDuha = enableDuha,
        enableNotifications = enableNotifications,
        enableAdhan = enableAdhan,
        selectedReciter = selectedReciter,
        selectedMuezzin = selectedMuezzin,
        selectedTheme = selectedTheme,
        isPremium = isPremium,
        premiumExpiryDate = premiumExpiryDate
    )

    private fun UserSettings.toEntity() = UserSettingsEntity(
        userId = userId,
        language = language,
        isDarkMode = isDarkMode,
        country = country,
        city = city,
        timezone = timezone,
        prayerCalculationMethod = prayerCalculationMethod,
        madhab = madhab,
        enableDuha = enableDuha,
        enableNotifications = enableNotifications,
        enableAdhan = enableAdhan,
        selectedReciter = selectedReciter,
        selectedMuezzin = selectedMuezzin,
        selectedTheme = selectedTheme,
        isPremium = isPremium,
        premiumExpiryDate = premiumExpiryDate
    )
}
