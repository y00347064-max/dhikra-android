package com.dhikra.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dhikra.app.data.local.entity.TasbihCountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TasbihCountDao {
    @Query("SELECT * FROM tasbih_counts ORDER BY date DESC LIMIT 1")
    fun getTodayCount(): Flow<TasbihCountEntity?>

    @Query("SELECT * FROM tasbih_counts ORDER BY date DESC")
    fun getAllCounts(): Flow<List<TasbihCountEntity>>

    @Insert
    suspend fun insertCount(count: TasbihCountEntity)

    @Update
    suspend fun updateCount(count: TasbihCountEntity)
}
