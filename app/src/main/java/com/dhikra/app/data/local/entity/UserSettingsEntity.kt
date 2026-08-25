package com.dhikra.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_settings")
data class UserSettingsEntity(
    @PrimaryKey
    val userId: String = "default_user",
    val language: String = "ar",
    val isDarkMode: Boolean = true,
    val country: String = "",
    val city: String = "",
    val timezone: String = "UTC",
    val prayerCalculationMethod: String = "Umm Al-Qura",
    val madhab: String = "Shafi'i",
    val enableDuha: Boolean = false,
    val enableNotifications: Boolean = true,
    val enableAdhan: Boolean = true,
    val selectedReciter: String = "",
    val selectedMuezzin: String = "",
    val selectedTheme: String = "default_dark",
    val isPremium: Boolean = false,
    val premiumExpiryDate: Long? = null
)
