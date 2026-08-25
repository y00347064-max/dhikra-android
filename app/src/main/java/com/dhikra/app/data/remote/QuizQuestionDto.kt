package com.dhikra.app.data.remote

import com.dhikra.app.domain.model.QuizQuestion

data class QuizQuestionResponse(
    val questions: List<QuizQuestionDto>
)

data class QuizQuestionDto(
    val id: String,
    val category: String,
    val difficulty: String,
    val questionArabic: String,
    val questionEnglish: String,
    val answers: List<String>,
    val correctAnswerIndex: Int,
    val animationAsset: String,
    val animationType: String,
    val explanation: String? = null,
    val xpReward: Int = 10
)

fun QuizQuestionDto.toDomain(): QuizQuestion {
    return QuizQuestion(
        questionId = id,
        category = category,
        difficulty = difficulty,
        questionArabic = questionArabic,
        questionEnglish = questionEnglish,
        answers = answers,
        correctAnswerIndex = correctAnswerIndex,
        animationAsset = animationAsset,
        animationType = animationType,
        explanation = explanation,
        xpReward = xpReward
    )
}
