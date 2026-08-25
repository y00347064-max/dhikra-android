package com.dhikra.app.domain.model

data class PrayerTimes(
    val fajr: String,
    val sunrise: String,
    val dhuhr: String,
    val asr: String,
    val maghrib: String,
    val isha: String,
    val date: String,
    val timezone: String,
    val method: String
)

data class Prayer(
    val name: String,
    val arabicName: String,
    val time: String,
    val nextTime: String? = null,
    val muezzin: Muezzin? = null,
    val hasNotification: Boolean = false,
    val countdownInMinutes: Int = 0
)
