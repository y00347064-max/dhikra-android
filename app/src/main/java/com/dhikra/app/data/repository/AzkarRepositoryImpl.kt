package com.dhikra.app.data.repository

import com.dhikra.app.data.local.AzkarDao
import com.dhikra.app.data.local.entity.AzkarEntity
import com.dhikra.app.domain.model.Azkar
import com.dhikra.app.domain.repository.AzkarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AzkarRepositoryImpl(
    private val azkarDao: AzkarDao
) : AzkarRepository {

    override fun getAzkarByCategory(category: String): Flow<List<Azkar>> =
        azkarDao.getAzkarByCategory(category).map { entities ->
            entities.map { it.toDomain() }
        }

    override fun getAllAzkar(): Flow<List<Azkar>> =
        azkarDao.getAllAzkar().map { entities ->
            entities.map { it.toDomain() }
        }

    override fun getFavoriteAzkar(): Flow<List<Azkar>> =
        azkarDao.getFavoriteAzkar().map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun insertAzkar(azkar: List<Azkar>) {
        azkarDao.insertAzkar(azkar.map { it.toEntity() })
    }

    override suspend fun updateAzkar(azkar: Azkar) {
        azkarDao.updateAzkar(azkar.toEntity())
    }

    private fun AzkarEntity.toDomain() = Azkar(
        id = id,
        category = category,
        arabicText = arabicText,
        englishTranslation = englishTranslation,
        reference = reference,
        count = count,
        currentCount = currentCount,
        isFavorite = isFavorite,
        isCompleted = isCompleted
    )

    private fun Azkar.toEntity() = AzkarEntity(
        id = id,
        category = category,
        arabicText = arabicText,
        englishTranslation = englishTranslation,
        reference = reference,
        count = count,
        currentCount = currentCount,
        isFavorite = isFavorite,
        isCompleted = isCompleted
    )
}
