package com.dhikra.app.domain.repository

import com.dhikra.app.domain.model.QuizQuestion
import kotlinx.coroutines.flow.Flow

interface QuizRepository {
    fun getQuestionsByCategory(category: String): Flow<List<QuizQuestion>>
    fun getQuestionsByDifficulty(difficulty: String): Flow<List<QuizQuestion>>
    fun getQuestionsByCategoryAndDifficulty(
        category: String,
        difficulty: String
    ): Flow<List<QuizQuestion>>
    suspend fun insertQuestions(questions: List<QuizQuestion>)
}
