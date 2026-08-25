package com.dhikra.app.domain.repository

import com.dhikra.app.domain.model.Azkar
import kotlinx.coroutines.flow.Flow

interface AzkarRepository {
    fun getAzkarByCategory(category: String): Flow<List<Azkar>>
    fun getAllAzkar(): Flow<List<Azkar>>
    fun getFavoriteAzkar(): Flow<List<Azkar>>
    suspend fun insertAzkar(azkar: List<Azkar>)
    suspend fun updateAzkar(azkar: Azkar)
}
