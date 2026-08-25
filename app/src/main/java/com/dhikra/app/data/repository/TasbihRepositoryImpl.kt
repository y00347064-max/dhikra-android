package com.dhikra.app.data.repository

import com.dhikra.app.data.local.TasbihCountDao
import com.dhikra.app.data.local.entity.TasbihCountEntity
import com.dhikra.app.domain.model.Tasbih
import com.dhikra.app.domain.repository.TasbihRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TasbihRepositoryImpl(
    private val tasbihDao: TasbihCountDao
) : TasbihRepository {

    override fun getTodayCount(): Flow<Tasbih?> =
        tasbihDao.getTodayCount().map { entity ->
            entity?.toDomain()
        }

    override fun getAllCounts(): Flow<List<Tasbih>> =
        tasbihDao.getAllCounts().map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun insertCount(count: Tasbih) {
        tasbihDao.insertCount(count.toEntity())
    }

    override suspend fun updateCount(count: Tasbih) {
        tasbihDao.updateCount(count.toEntity())
    }

    private fun TasbihCountEntity.toDomain() = Tasbih(
        id = id,
        date = date,
        totalCount = totalCount,
        dailyGoal = dailyGoal,
        streak = streak,
        lastUpdated = lastUpdated
    )

    private fun Tasbih.toEntity() = TasbihCountEntity(
        id = id,
        date = date,
        totalCount = totalCount,
        dailyGoal = dailyGoal,
        streak = streak,
        lastUpdated = lastUpdated
    )
}
