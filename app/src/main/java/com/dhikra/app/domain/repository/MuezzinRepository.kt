package com.dhikra.app.domain.repository

import com.dhikra.app.domain.model.Muezzin
import kotlinx.coroutines.flow.Flow

interface MuezzinRepository {
    fun getAllMuezzins(): Flow<List<Muezzin>>
    fun getFreeMuezzins(): Flow<List<Muezzin>>
    fun getPremiumMuezzins(): Flow<List<Muezzin>>
    fun getFavoriteMuezzins(): Flow<List<Muezzin>>
    suspend fun insertMuezzins(muezzins: List<Muezzin>)
    suspend fun updateFavorite(muezzinId: String, isFavorite: Boolean)
}
