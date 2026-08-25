package com.dhikra.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_questions")
data class QuizQuestionEntity(
    @PrimaryKey
    val questionId: String,
    val category: String, // Islamic Quiz, Quran Knowledge, etc.
    val difficulty: String, // Easy, Medium, Hard, Expert
    val questionArabic: String,
    val questionEnglish: String,
    val answers: String, // JSON array
    val correctAnswerIndex: Int,
    val animationAsset: String, // Animation resource identifier
    val animationType: String, // LOOP, ONCE, etc.
    val explanation: String? = null,
    val xpReward: Int = 10
)
