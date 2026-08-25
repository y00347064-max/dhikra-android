package com.dhikra.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dhikra.app.data.local.entity.ThemeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ThemeDao {
    @Query("SELECT * FROM themes ORDER BY name ASC")
    fun getAllThemes(): Flow<List<ThemeEntity>>

    @Query("SELECT * FROM themes WHERE isPremium = 0")
    fun getFreeThemes(): Flow<List<ThemeEntity>>

    @Query("SELECT * FROM themes WHERE isPremium = 1")
    fun getPremiumThemes(): Flow<List<ThemeEntity>>

    @Query("SELECT * FROM themes WHERE isSelected = 1 LIMIT 1")
    fun getSelectedTheme(): Flow<ThemeEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThemes(themes: List<ThemeEntity>)

    @Query("UPDATE themes SET isSelected = 0")
    suspend fun deselectAllThemes()

    @Query("UPDATE themes SET isSelected = 1 WHERE themeId = :themeId")
    suspend fun selectTheme(themeId: String)
}
