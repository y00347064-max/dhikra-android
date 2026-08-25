package com.dhikra.app.data.repository

import com.dhikra.app.data.local.BookmarkDao
import com.dhikra.app.data.local.entity.BookmarkEntity
import com.dhikra.app.domain.model.Bookmark
import com.dhikra.app.domain.repository.BookmarkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class BookmarkRepositoryImpl(
    private val bookmarkDao: BookmarkDao
) : BookmarkRepository {

    override fun getAllBookmarks(): Flow<List<Bookmark>> =
        bookmarkDao.getAllBookmarks().map { entities ->
            entities.map { it.toDomain() }
        }

    override fun getBookmarksBySurah(surahNumber: Int): Flow<List<Bookmark>> =
        bookmarkDao.getBookmarksBySurah(surahNumber).map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun insertBookmark(bookmark: Bookmark) {
        bookmarkDao.insertBookmark(bookmark.toEntity())
    }

    override suspend fun deleteBookmark(bookmark: Bookmark) {
        bookmarkDao.deleteBookmark(bookmark.toEntity())
    }

    private fun BookmarkEntity.toDomain() = Bookmark(
        id = id,
        surahNumber = surahNumber,
        ayahNumber = ayahNumber,
        timestamp = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(timestamp),
            ZoneId.systemDefault()
        ),
        note = note
    )

    private fun Bookmark.toEntity() = BookmarkEntity(
        id = id,
        surahNumber = surahNumber,
        ayahNumber = ayahNumber,
        timestamp = timestamp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(),
        note = note
    )
}
