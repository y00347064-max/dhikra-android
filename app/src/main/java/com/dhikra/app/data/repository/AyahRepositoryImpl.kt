package com.dhikra.app.data.repository

import com.dhikra.app.data.local.AyahDao
import com.dhikra.app.data.local.entity.AyahEntity
import com.dhikra.app.domain.model.Ayah
import com.dhikra.app.domain.repository.AyahRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AyahRepositoryImpl(
    private val ayahDao: AyahDao
) : AyahRepository {

    override fun getAyahsBySurah(surahNumber: Int): Flow<List<Ayah>> =
        ayahDao.getAyahsBySurah(surahNumber).map { entities ->
            entities.map { it.toDomain() }
        }

    override fun getAyah(surahNumber: Int, ayahNumber: Int): Flow<Ayah?> =
        ayahDao.getAyah(surahNumber, ayahNumber).map { it?.toDomain() }

    override fun searchAyahs(query: String): Flow<List<Ayah>> =
        ayahDao.searchAyahs(query).map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun insertAyahs(ayahs: List<Ayah>) {
        ayahDao.insertAyahs(ayahs.map { it.toEntity() })
    }

    private fun AyahEntity.toDomain() = Ayah(
        id = id,
        surahNumber = surahNumber,
        ayahNumber = ayahNumber,
        arabicText = arabicText,
        englishTranslation = englishTranslation,
        transliteration = transliteration,
        tafsir = tafsir,
        tajweedRules = tajweedRules
    )

    private fun Ayah.toEntity() = AyahEntity(
        id = id,
        surahNumber = surahNumber,
        ayahNumber = ayahNumber,
        arabicText = arabicText,
        englishTranslation = englishTranslation,
        transliteration = transliteration,
        tafsir = tafsir,
        tajweedRules = tajweedRules
    )
}
