package com.example.fitnessapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ActivityDao {

    @Insert
    suspend fun insertActivity(activity: Activity)

    @Query("SELECT * FROM activities")
    fun getAllActivities(): LiveData<List<Activity>>
}
