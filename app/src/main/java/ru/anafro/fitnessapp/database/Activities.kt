package com.example.fitnessapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*

@Entity(tableName = "activities")
data class Activity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: ActivityType,
    val startTime: Long,
    val endTime: Long,
    val coordinates: List<Coordinate>
)

enum class ActivityType {
    CYCLING, RUNNING, WALKING, SWIMMING
}

data class Coordinate(
    val latitude: Double,
    val longitude: Double
)
