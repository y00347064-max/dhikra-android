package com.dhikra.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dhikra.app.data.local.entity.AyahEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AyahDao {
    @Query("SELECT * FROM ayahs WHERE surahNumber = :surahNumber ORDER BY ayahNumber ASC")
    fun getAyahsBySurah(surahNumber: Int): Flow<List<AyahEntity>>

    @Query("SELECT * FROM ayahs WHERE surahNumber = :surahNumber AND ayahNumber = :ayahNumber")
    fun getAyah(surahNumber: Int, ayahNumber: Int): Flow<AyahEntity>

    @Query("SELECT * FROM ayahs WHERE LOWER(arabicText) LIKE '%' || :query || '%' OR LOWER(englishTranslation) LIKE '%' || :query || '%'")
    fun searchAyahs(query: String): Flow<List<AyahEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAyahs(ayahs: List<AyahEntity>)
}
