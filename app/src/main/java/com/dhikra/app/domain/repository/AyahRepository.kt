package com.dhikra.app.domain.repository

import com.dhikra.app.domain.model.Ayah
import kotlinx.coroutines.flow.Flow

interface AyahRepository {
    fun getAyahsBySurah(surahNumber: Int): Flow<List<Ayah>>
    fun getAyah(surahNumber: Int, ayahNumber: Int): Flow<Ayah?>
    fun searchAyahs(query: String): Flow<List<Ayah>>
    suspend fun insertAyahs(ayahs: List<Ayah>)
}
