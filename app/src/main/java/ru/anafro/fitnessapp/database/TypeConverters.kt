package com.example.fitnessapp.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromCoordinateList(coordinates: List<Coordinate>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Coordinate>>() {}.type
        return gson.toJson(coordinates, type)
    }

    @TypeConverter
    fun toCoordinateList(coordinatesString: String): List<Coordinate> {
        val gson = Gson()
        val type = object : TypeToken<List<Coordinate>>() {}.type
        return gson.fromJson(coordinatesString, type)
    }
}
