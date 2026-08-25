package com.dhikra.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "muezzins")
data class MuezzinEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val country: String,
    val imageUrl: String? = null,
    val adhanUrl: String,
    val iqamaUrl: String? = null,
    val isFavorite: Boolean = false,
    val isPremium: Boolean = false,
    val source: String, // Source/Attribution
    val license: String? = null
)
