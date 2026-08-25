package com.dhikra.app.data.remote

import com.dhikra.app.domain.model.PrayerTimes
import retrofit2.http.GET
import retrofit2.http.Query

interface PrayerTimesService {
    @GET("timingsByCity")
    suspend fun getPrayerTimesByCity(
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("method") method: Int = 4 // Umm Al-Qura
    ): PrayerTimesResponse

    @GET("timings/{date}")
    suspend fun getPrayerTimings(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("method") method: Int = 4
    ): PrayerTimingsResponse
}

data class PrayerTimesResponse(
    val status: String,
    val data: Map<String, Any>
)

data class PrayerTimingsResponse(
    val status: String,
    val data: Map<String, Any>
)
