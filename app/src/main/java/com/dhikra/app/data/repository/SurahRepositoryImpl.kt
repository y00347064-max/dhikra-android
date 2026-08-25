package com.dhikra.app.data.repository

import com.dhikra.app.data.local.SurahDao
import com.dhikra.app.data.local.entity.SurahEntity
import com.dhikra.app.domain.model.Surah
import com.dhikra.app.domain.repository.SurahRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SurahRepositoryImpl(
    private val surahDao: SurahDao
) : SurahRepository {

    override fun getAllSurahs(): Flow<List<Surah>> =
        surahDao.getAllSurahs().map { entities ->
            entities.map { it.toDomain() }
        }

    override fun getSurahByNumber(surahNumber: Int): Flow<Surah?> =
        surahDao.getSurahByNumber(surahNumber).map { it?.toDomain() }

    override fun searchSurahs(query: String): Flow<List<Surah>> =
        surahDao.searchSurahs(query).map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun insertSurahs(surahs: List<Surah>) {
        surahDao.insertSurahs(surahs.map { it.toEntity() })
    }

    override suspend fun updateLastReadAyah(surahNumber: Int, ayahNumber: Int) {
        surahDao.updateLastReadAyah(surahNumber, ayahNumber)
    }

    private fun SurahEntity.toDomain() = Surah(
        number = number,
        arabicName = arabicName,
        englishName = englishName,
        transliteratedName = transliteratedName,
        revelationType = revelationType,
        numberOfAyahs = numberOfAyahs,
        meaning = meaning,
        lastReadAyah = lastReadAyah
    )

    private fun Surah.toEntity() = SurahEntity(
        number = number,
        arabicName = arabicName,
        englishName = englishName,
        transliteratedName = transliteratedName,
        revelationType = revelationType,
        numberOfAyahs = numberOfAyahs,
        meaning = meaning,
        lastReadAyah = lastReadAyah
    )
}
