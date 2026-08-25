package com.dhikra.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dhikra.app.data.local.entity.AzkarEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AzkarDao {
    @Query("SELECT * FROM azkar WHERE category = :category")
    fun getAzkarByCategory(category: String): Flow<List<AzkarEntity>>

    @Query("SELECT * FROM azkar")
    fun getAllAzkar(): Flow<List<AzkarEntity>>

    @Query("SELECT * FROM azkar WHERE isFavorite = 1")
    fun getFavoriteAzkar(): Flow<List<AzkarEntity>>

    @Insert
    suspend fun insertAzkar(azkar: List<AzkarEntity>)

    @Update
    suspend fun updateAzkar(azkar: AzkarEntity)
}
