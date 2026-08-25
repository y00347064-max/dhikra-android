package com.dhikra.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dhikra.app.data.local.entity.*

@Database(
    entities = [
        SurahEntity::class,
        AyahEntity::class,
        BookmarkEntity::class,
        FavoriteEntity::class,
        ReciterEntity::class,
        MuezzinEntity::class,
        AzkarEntity::class,
        TasbihCountEntity::class,
        QuizQuestionEntity::class,
        UserProgressEntity::class,
        ThemeEntity::class,
        UserSettingsEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun surahDao(): SurahDao
    abstract fun ayahDao(): AyahDao
    abstract fun bookmarkDao(): BookmarkDao
    abstract fun favoriteDao(): FavoriteDao
    abstract fun reciterDao(): ReciterDao
    abstract fun muezzinDao(): MuezzinDao
    abstract fun azkarDao(): AzkarDao
    abstract fun tasbihDao(): TasbihCountDao
    abstract fun quizQuestionDao(): QuizQuestionDao
    abstract fun userProgressDao(): UserProgressDao
    abstract fun themeDao(): ThemeDao
    abstract fun settingsDao(): UserSettingsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "dhikra_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
