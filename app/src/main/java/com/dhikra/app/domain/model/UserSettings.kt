package com.dhikra.app.domain.model

data class UserSettings(
    val userId: String,
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
