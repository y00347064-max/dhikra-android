package com.dhikra.app.data.repository

import com.dhikra.app.data.local.MuezzinDao
import com.dhikra.app.data.local.entity.MuezzinEntity
import com.dhikra.app.domain.model.Muezzin
import com.dhikra.app.domain.repository.MuezzinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MuezzinRepositoryImpl(
    private val muezzinDao: MuezzinDao
) : MuezzinRepository {

    override fun getAllMuezzins(): Flow<List<Muezzin>> =
        muezzinDao.getAllMuezzins().map { entities ->
            entities.map { it.toDomain() }
        }

    override fun getFreeMuezzins(): Flow<List<Muezzin>> =
        muezzinDao.getFreeMuezzins().map { entities ->
            entities.map { it.toDomain() }
        }

    override fun getPremiumMuezzins(): Flow<List<Muezzin>> =
        muezzinDao.getPremiumMuezzins().map { entities ->
            entities.map { it.toDomain() }
        }

    override fun getFavoriteMuezzins(): Flow<List<Muezzin>> =
        muezzinDao.getFavoriteMuezzins().map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun insertMuezzins(muezzins: List<Muezzin>) {
        muezzinDao.insertMuezzins(muezzins.map { it.toEntity() })
    }

    override suspend fun updateFavorite(muezzinId: String, isFavorite: Boolean) {
        muezzinDao.updateFavorite(muezzinId, isFavorite)
    }

    private fun MuezzinEntity.toDomain() = Muezzin(
        id = id,
        name = name,
        country = country,
        imageUrl = imageUrl,
        adhanUrl = adhanUrl,
        iqamaUrl = iqamaUrl,
        isFavorite = isFavorite,
        isPremium = isPremium,
        source = source,
        license = license
    )

    private fun Muezzin.toEntity() = MuezzinEntity(
        id = id,
        name = name,
        country = country,
        imageUrl = imageUrl,
        adhanUrl = adhanUrl,
        iqamaUrl = iqamaUrl,
        isFavorite = isFavorite,
        isPremium = isPremium,
        source = source,
        license = license
    )
}
