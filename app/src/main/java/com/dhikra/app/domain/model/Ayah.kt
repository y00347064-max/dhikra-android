package com.dhikra.app.domain.model

data class Ayah(
    val id: Int,
    val surahNumber: Int,
    val ayahNumber: Int,
    val arabicText: String,
    val englishTranslation: String,
    val transliteration: String,
    val tafsir: String? = null,
    val tajweedRules: String? = null
)
