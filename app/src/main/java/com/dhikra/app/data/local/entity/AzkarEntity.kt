package com.dhikra.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "azkar")
data class AzkarEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val category: String, // Morning, Evening, AfterPrayer, Sleep, etc.
    val arabicText: String,
    val englishTranslation: String,
    val reference: String, // Hadith source
    val count: Int = 1,
    val currentCount: Int = 0,
    val isFavorite: Boolean = false,
    val isCompleted: Boolean = false
)
