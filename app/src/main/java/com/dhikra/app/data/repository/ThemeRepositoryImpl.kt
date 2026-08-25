package com.dhikra.app.data.repository

import com.dhikra.app.data.local.ThemeDao
import com.dhikra.app.data.local.entity.ThemeEntity
import com.dhikra.app.domain.model.Theme
import com.dhikra.app.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ThemeRepositoryImpl(
    private val themeDao: ThemeDao
) : ThemeRepository {

    override fun getAllThemes(): Flow<List<Theme>> =
        themeDao.getAllThemes().map { entities ->
            entities.map { it.toDomain() }
        }

    override fun getFreeThemes(): Flow<List<Theme>> =
        themeDao.getFreeThemes().map { entities ->
            entities.map { it.toDomain() }
        }

    override fun getPremiumThemes(): Flow<List<Theme>> =
        themeDao.getPremiumThemes().map { entities ->
            entities.map { it.toDomain() }
        }

    override fun getSelectedTheme(): Flow<Theme?> =
        themeDao.getSelectedTheme().map { entity ->
            entity?.toDomain()
        }

    override suspend fun insertThemes(themes: List<Theme>) {
        themeDao.insertThemes(themes.map { it.toEntity() })
    }

    override suspend fun selectTheme(themeId: String) {
        themeDao.deselectAllThemes()
        themeDao.selectTheme(themeId)
    }

    private fun ThemeEntity.toDomain() = Theme(
        themeId = themeId,
        name = name,
        description = description,
        primaryColor = primaryColor,
        secondaryColor = secondaryColor,
        accentColor = accentColor,
        backgroundColor = backgroundColor,
        isPremium = isPremium,
        isSelected = isSelected
    )

    private fun Theme.toEntity() = ThemeEntity(
        themeId = themeId,
        name = name,
        description = description,
        primaryColor = primaryColor,
        secondaryColor = secondaryColor,
        accentColor = accentColor,
        backgroundColor = backgroundColor,
        isPremium = isPremium,
        isSelected = isSelected
    )
}
