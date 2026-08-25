package com.dhikra.app.domain.model

data class Tasbih(
    val id: Int,
    val date: String,
    val totalCount: Int = 0,
    val dailyGoal: Int = 100,
    val streak: Int = 0,
    val lastUpdated: Long = System.currentTimeMillis()
)
