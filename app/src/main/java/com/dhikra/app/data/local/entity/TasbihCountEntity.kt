package com.dhikra.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tasbih_counts")
data class TasbihCountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String = LocalDate.now().toString(),
    val totalCount: Int = 0,
    val dailyGoal: Int = 100,
    val streak: Int = 0,
    val lastUpdated: Long = System.currentTimeMillis()
)
