package com.dhikra.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reciters")
data class ReciterEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val country: String,
    val imageUrl: String? = null,
    val audioUrl: String,
    val isFavorite: Boolean = false,
    val availableSurahs: String, // JSON array
    val style: String? = null // Tajweed, Hafs, etc.
)
