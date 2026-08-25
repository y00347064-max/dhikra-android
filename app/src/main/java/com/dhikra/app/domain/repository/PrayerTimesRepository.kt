package com.dhikra.app.domain.repository

import com.dhikra.app.domain.model.PrayerTimes
import com.dhikra.app.domain.model.Prayer

interface PrayerTimesRepository {
    suspend fun getPrayerTimes(
        latitude: Double,
        longitude: Double,
        method: String = "Umm Al-Qura"
    ): Result<PrayerTimes>

    suspend fun getPrayerTimesForCity(
        city: String,
        method: String = "Umm Al-Qura"
    ): Result<PrayerTimes>

    fun getNextPrayer(prayerTimes: PrayerTimes): Prayer?
}
