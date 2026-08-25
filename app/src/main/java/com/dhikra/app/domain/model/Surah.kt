package com.dhikra.app.domain.model

data class Surah(
    val number: Int,
    val arabicName: String,
    val englishName: String,
    val transliteratedName: String,
    val revelationType: String, // Makki or Madani
    val numberOfAyahs: Int,
    val meaning: String,
    val lastReadAyah: Int = 0
)
