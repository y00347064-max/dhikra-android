package com.dhikra.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dhikra.app.data.local.entity.ReciterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReciterDao {
    @Query("SELECT * FROM reciters ORDER BY name ASC")
    fun getAllReciters(): Flow<List<ReciterEntity>>

    @Query("SELECT * FROM reciters WHERE id = :reciterId")
    fun getReciterById(reciterId: String): Flow<ReciterEntity>

    @Query("SELECT * FROM reciters WHERE isFavorite = 1")
    fun getFavoriteReciters(): Flow<List<ReciterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReciters(reciters: List<ReciterEntity>)

    @Query("UPDATE reciters SET isFavorite = :isFavorite WHERE id = :reciterId")
    suspend fun updateFavorite(reciterId: String, isFavorite: Boolean)
}
