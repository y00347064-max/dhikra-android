package com.dhikra.app.domain.model

data class Azkar(
    val id: Int,
    val category: String, // Morning, Evening, AfterPrayer, Sleep, etc.
    val arabicText: String,
    val englishTranslation: String,
    val reference: String, // Hadith source
    val count: Int = 1,
    val currentCount: Int = 0,
    val isFavorite: Boolean = false,
    val isCompleted: Boolean = false
)
