package com.dhikra.app.data.repository

import com.dhikra.app.data.local.QuizQuestionDao
import com.dhikra.app.data.local.entity.QuizQuestionEntity
import com.dhikra.app.domain.model.QuizQuestion
import com.dhikra.app.domain.repository.QuizRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuizRepositoryImpl(
    private val quizQuestionDao: QuizQuestionDao,
    private val gson: Gson
) : QuizRepository {

    override fun getQuestionsByCategory(category: String): Flow<List<QuizQuestion>> =
        quizQuestionDao.getQuestionsByCategory(category).map { entities ->
            entities.map { it.toDomain(gson) }
        }

    override fun getQuestionsByDifficulty(difficulty: String): Flow<List<QuizQuestion>> =
        quizQuestionDao.getQuestionsByDifficulty(difficulty).map { entities ->
            entities.map { it.toDomain(gson) }
        }

    override fun getQuestionsByCategoryAndDifficulty(
        category: String,
        difficulty: String
    ): Flow<List<QuizQuestion>> =
        quizQuestionDao.getQuestionsByCategoryAndDifficulty(category, difficulty).map { entities ->
            entities.map { it.toDomain(gson) }
        }

    override suspend fun insertQuestions(questions: List<QuizQuestion>) {
        quizQuestionDao.insertQuestions(questions.map { it.toEntity(gson) })
    }

    private fun QuizQuestionEntity.toDomain(gson: Gson) = QuizQuestion(
        questionId = questionId,
        category = category,
        difficulty = difficulty,
        questionArabic = questionArabic,
        questionEnglish = questionEnglish,
        answers = try {
            gson.fromJson(answers, Array<String>::class.java).toList()
        } catch (e: Exception) {
            emptyList()
        },
        correctAnswerIndex = correctAnswerIndex,
        animationAsset = animationAsset,
        animationType = animationType,
        explanation = explanation,
        xpReward = xpReward
    )

    private fun QuizQuestion.toEntity(gson: Gson) = QuizQuestionEntity(
        questionId = questionId,
        category = category,
        difficulty = difficulty,
        questionArabic = questionArabic,
        questionEnglish = questionEnglish,
        answers = gson.toJson(answers),
        correctAnswerIndex = correctAnswerIndex,
        animationAsset = animationAsset,
        animationType = animationType,
        explanation = explanation,
        xpReward = xpReward
    )
}
