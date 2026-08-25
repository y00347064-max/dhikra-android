package com.dhikra.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "themes")
data class ThemeEntity(
    @PrimaryKey
    val themeId: String,
    val name: String,
    val description: String? = null,
    val primaryColor: Long,
    val secondaryColor: Long,
    val accentColor: Long,
    val backgroundColor: Long,
    val isPremium: Boolean = false,
    val isSelected: Boolean = false
)
