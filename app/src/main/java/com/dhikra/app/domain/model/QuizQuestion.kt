package com.dhikra.app.domain.model

data class QuizQuestion(
    val questionId: String,
    val category: String, // Islamic Quiz, Quran Knowledge, etc.
    val difficulty: String, // Easy, Medium, Hard, Expert
    val questionArabic: String,
    val questionEnglish: String,
    val answers: List<String>,
    val correctAnswerIndex: Int,
    val animationAsset: String,
    val animationType: String, // LOOP, ONCE, etc.
    val explanation: String? = null,
    val xpReward: Int = 10
)
