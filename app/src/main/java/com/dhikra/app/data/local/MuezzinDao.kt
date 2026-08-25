package com.dhikra.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dhikra.app.data.local.entity.MuezzinEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MuezzinDao {
    @Query("SELECT * FROM muezzins ORDER BY name ASC")
    fun getAllMuezzins(): Flow<List<MuezzinEntity>>

    @Query("SELECT * FROM muezzins WHERE isPremium = 0 ORDER BY name ASC")
    fun getFreeMuezzins(): Flow<List<MuezzinEntity>>

    @Query("SELECT * FROM muezzins WHERE isPremium = 1 ORDER BY name ASC")
    fun getPremiumMuezzins(): Flow<List<MuezzinEntity>>

    @Query("SELECT * FROM muezzins WHERE isFavorite = 1")
    fun getFavoriteMuezzins(): Flow<List<MuezzinEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMuezzins(muezzins: List<MuezzinEntity>)

    @Query("UPDATE muezzins SET isFavorite = :isFavorite WHERE id = :muezzinId")
    suspend fun updateFavorite(muezzinId: String, isFavorite: Boolean)
}
