package com.dhikra.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val surahNumber: Int,
    val ayahNumber: Int,
    val type: String, // SURAH, AYAH, AZKAR
    val timestamp: Long = System.currentTimeMillis()
)
