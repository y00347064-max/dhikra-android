package com.dhikra.app.data.repository

import com.dhikra.app.data.local.ReciterDao
import com.dhikra.app.data.local.entity.ReciterEntity
import com.dhikra.app.domain.model.Reciter
import com.dhikra.app.domain.repository.ReciterRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ReciterRepositoryImpl(
    private val reciterDao: ReciterDao,
    private val gson: Gson
) : ReciterRepository {

    override fun getAllReciters(): Flow<List<Reciter>> =
        reciterDao.getAllReciters().map { entities ->
            entities.map { it.toDomain(gson) }
        }

    override fun getReciterById(reciterId: String): Flow<Reciter?> =
        reciterDao.getReciterById(reciterId).map { it?.toDomain(gson) }

    override fun getFavoriteReciters(): Flow<List<Reciter>> =
        reciterDao.getFavoriteReciters().map { entities ->
            entities.map { it.toDomain(gson) }
        }

    override suspend fun insertReciters(reciters: List<Reciter>) {
        reciterDao.insertReciters(reciters.map { it.toEntity(gson) })
    }

    override suspend fun updateFavorite(reciterId: String, isFavorite: Boolean) {
        reciterDao.updateFavorite(reciterId, isFavorite)
    }

    private fun ReciterEntity.toDomain(gson: Gson) = Reciter(
        id = id,
        name = name,
        country = country,
        imageUrl = imageUrl,
        audioUrl = audioUrl,
        isFavorite = isFavorite,
        availableSurahs = try {
            gson.fromJson(availableSurahs, Array<Int>::class.java).toList()
        } catch (e: Exception) {
            emptyList()
        },
        style = style
    )

    private fun Reciter.toEntity(gson: Gson) = ReciterEntity(
        id = id,
        name = name,
        country = country,
        imageUrl = imageUrl,
        audioUrl = audioUrl,
        isFavorite = isFavorite,
        availableSurahs = gson.toJson(availableSurahs),
        style = style
    )
}
