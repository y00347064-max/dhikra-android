package com.dhikra.app.domain.model

data class UserProgress(
    val userId: String,
    val currentLevel: Int = 1,
    val totalXP: Int = 0,
    val dailyXP: Int = 0,
    val streak: Int = 0,
    val totalQuizzes: Int = 0,
    val correctAnswers: Int = 0,
    val completedLevels: List<Int> = emptyList(),
    val achievements: List<String> = emptyList(),
    val lastActivityDate: Long = System.currentTimeMillis()
)
