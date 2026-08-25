package com.dhikra.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_progress")
data class UserProgressEntity(
    @PrimaryKey
    val userId: String = "default_user",
    val currentLevel: Int = 1,
    val totalXP: Int = 0,
    val dailyXP: Int = 0,
    val streak: Int = 0,
    val totalQuizzes: Int = 0,
    val correctAnswers: Int = 0,
    val completedLevels: String = "", // JSON array
    val achievements: String = "", // JSON array
    val lastActivityDate: Long = System.currentTimeMillis()
)
