package ru.anafro.fitnessapp.models

data class Activity(
    val id: String,
    val name: String,
    val distance: String,
    val duration: String,
    val startTime: String,
    val endTime: String,
    val timeAgo: String,
    val comment: String
)

fun getActivities(): List<Activity> {
    return listOf(
        Activity("1", "Cycling", "10 km", "1 hour", "10:00", "11:00", "2 hours ago", ""),
        Activity("2", "Running", "5 km", "30 minutes", "12:00", "12:30", "1 hour ago", "")
    )
}

fun getActivityById(id: String): Activity {
    return getActivities().first { it.id == id }
}