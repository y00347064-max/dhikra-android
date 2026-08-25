package com.dhikra.app.domain.model

data class Theme(
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
