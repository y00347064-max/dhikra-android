package com.dhikra.app.domain.repository

import com.dhikra.app.domain.model.Tasbih
import kotlinx.coroutines.flow.Flow

interface TasbihRepository {
    fun getTodayCount(): Flow<Tasbih?>
    fun getAllCounts(): Flow<List<Tasbih>>
    suspend fun insertCount(count: Tasbih)
    suspend fun updateCount(count: Tasbih)
}
