package com.dhikra.app.domain.repository

import com.dhikra.app.domain.model.UserProgress
import kotlinx.coroutines.flow.Flow

interface UserProgressRepository {
    fun getUserProgress(userId: String): Flow<UserProgress?>
    suspend fun insertProgress(progress: UserProgress)
    suspend fun updateProgress(progress: UserProgress)
}
