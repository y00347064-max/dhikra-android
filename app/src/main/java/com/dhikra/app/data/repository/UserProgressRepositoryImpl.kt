package com.dhikra.app.data.repository

import com.dhikra.app.data.local.UserProgressDao
import com.dhikra.app.data.local.entity.UserProgressEntity
import com.dhikra.app.domain.model.UserProgress
import com.dhikra.app.domain.repository.UserProgressRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserProgressRepositoryImpl(
    private val userProgressDao: UserProgressDao,
    private val gson: Gson
) : UserProgressRepository {

    override fun getUserProgress(userId: String): Flow<UserProgress?> =
        userProgressDao.getUserProgress(userId).map { entity ->
            entity?.toDomain(gson)
        }

    override suspend fun insertProgress(progress: UserProgress) {
        userProgressDao.insertProgress(progress.toEntity(gson))
    }

    override suspend fun updateProgress(progress: UserProgress) {
        userProgressDao.updateProgress(progress.toEntity(gson))
    }

    private fun UserProgressEntity.toDomain(gson: Gson) = UserProgress(
        userId = userId,
        currentLevel = currentLevel,
        totalXP = totalXP,
        dailyXP = dailyXP,
        streak = streak,
        totalQuizzes = totalQuizzes,
        correctAnswers = correctAnswers,
        completedLevels = try {
            gson.fromJson(completedLevels, Array<Int>::class.java).toList()
        } catch (e: Exception) {
            emptyList()
        },
        achievements = try {
            gson.fromJson(achievements, Array<String>::class.java).toList()
        } catch (e: Exception) {
            emptyList()
        },
        lastActivityDate = lastActivityDate
    )

    private fun UserProgress.toEntity(gson: Gson) = UserProgressEntity(
        userId = userId,
        currentLevel = currentLevel,
        totalXP = totalXP,
        dailyXP = dailyXP,
        streak = streak,
        totalQuizzes = totalQuizzes,
        correctAnswers = correctAnswers,
        completedLevels = gson.toJson(completedLevels),
        achievements = gson.toJson(achievements),
        lastActivityDate = lastActivityDate
    )
}
