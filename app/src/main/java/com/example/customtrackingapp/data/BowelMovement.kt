package com.example.customtrackingapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bowel_movements")
data class BowelMovement(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val startDay: String,
    val endDay: String,
    val startTime: String, //TODO: Learn how to se type converters
    val endTime: String
)