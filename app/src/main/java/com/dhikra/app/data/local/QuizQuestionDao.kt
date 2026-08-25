package com.dhikra.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dhikra.app.data.local.entity.QuizQuestionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizQuestionDao {
    @Query("SELECT * FROM quiz_questions WHERE category = :category ORDER BY difficulty ASC")
    fun getQuestionsByCategory(category: String): Flow<List<QuizQuestionEntity>>

    @Query("SELECT * FROM quiz_questions WHERE difficulty = :difficulty")
    fun getQuestionsByDifficulty(difficulty: String): Flow<List<QuizQuestionEntity>>

    @Query("SELECT * FROM quiz_questions WHERE category = :category AND difficulty = :difficulty")
    fun getQuestionsByCategoryAndDifficulty(
        category: String,
        difficulty: String
    ): Flow<List<QuizQuestionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<QuizQuestionEntity>)
}
