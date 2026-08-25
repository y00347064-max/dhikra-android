package com.dhikra.app.domain.model

data class Muezzin(
    val id: String,
    val name: String,
    val country: String,
    val imageUrl: String? = null,
    val adhanUrl: String,
    val iqamaUrl: String? = null,
    val isFavorite: Boolean = false,
    val isPremium: Boolean = false,
    val source: String,
    val license: String? = null
)
