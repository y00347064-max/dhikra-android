package com.dhikra.app.domain.model

data class Reciter(
    val id: String,
    val name: String,
    val country: String,
    val imageUrl: String? = null,
    val audioUrl: String,
    val isFavorite: Boolean = false,
    val availableSurahs: List<Int>,
    val style: String? = null // Tajweed, Hafs, etc.
)
