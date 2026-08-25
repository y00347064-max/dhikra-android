package com.dhikra.app.domain.repository

import com.dhikra.app.domain.model.Surah
import kotlinx.coroutines.flow.Flow

interface SurahRepository {
    fun getAllSurahs(): Flow<List<Surah>>
    fun getSurahByNumber(surahNumber: Int): Flow<Surah?>
    fun searchSurahs(query: String): Flow<List<Surah>>
    suspend fun insertSurahs(surahs: List<Surah>)
    suspend fun updateLastReadAyah(surahNumber: Int, ayahNumber: Int)
}
