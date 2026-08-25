package com.dhikra.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dhikra.app.data.local.entity.SurahEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SurahDao {
    @Query("SELECT * FROM surahs ORDER BY number ASC")
    fun getAllSurahs(): Flow<List<SurahEntity>>

    @Query("SELECT * FROM surahs WHERE number = :surahNumber")
    fun getSurahByNumber(surahNumber: Int): Flow<SurahEntity>

    @Query("SELECT * FROM surahs WHERE LOWER(englishName) LIKE '%' || :query || '%' OR LOWER(arabicName) LIKE '%' || :query || '%'")
    fun searchSurahs(query: String): Flow<List<SurahEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurahs(surahs: List<SurahEntity>)

    @Query("UPDATE surahs SET lastReadAyah = :ayahNumber WHERE number = :surahNumber")
    suspend fun updateLastReadAyah(surahNumber: Int, ayahNumber: Int)
}
