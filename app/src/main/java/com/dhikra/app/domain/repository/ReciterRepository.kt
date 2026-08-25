package com.dhikra.app.domain.repository

import com.dhikra.app.domain.model.Reciter
import kotlinx.coroutines.flow.Flow

interface ReciterRepository {
    fun getAllReciters(): Flow<List<Reciter>>
    fun getReciterById(reciterId: String): Flow<Reciter?>
    fun getFavoriteReciters(): Flow<List<Reciter>>
    suspend fun insertReciters(reciters: List<Reciter>)
    suspend fun updateFavorite(reciterId: String, isFavorite: Boolean)
}
