package com.dhikra.app.domain.model

import java.time.LocalDateTime

data class Bookmark(
    val id: Int,
    val surahNumber: Int,
    val ayahNumber: Int,
    val timestamp: LocalDateTime,
    val note: String? = null
)
