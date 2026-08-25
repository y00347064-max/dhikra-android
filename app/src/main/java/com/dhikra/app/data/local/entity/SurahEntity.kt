package com.dhikra.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "surahs")
data class SurahEntity(
    @PrimaryKey
    val number: Int,
    val arabicName: String,
    val englishName: String,
    val transliteratedName: String,
    val revelationType: String, // Makki or Madani
    val numberOfAyahs: Int,
    val meaning: String,
    val lastReadAyah: Int = 0
)
