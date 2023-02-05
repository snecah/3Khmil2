package com.example.movies.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class ListTypeConverter {

    @TypeConverter
    fun fromCountryList(value: List<Country>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun fromGenreList(value: List<Genre>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toCountryList(value: String): List<Country> {
        return try {
            val listType: Type = object : TypeToken<ArrayList<Country?>?>() {}.type
            Gson().fromJson(value, listType)
        } catch (e: Exception) {
            arrayListOf()
        }
    }

    @TypeConverter
    fun toGenreList(value: String): List<Genre> {
        return try {
            val listType: Type = object : TypeToken<ArrayList<Genre?>?>() {}.type
            Gson().fromJson(value, listType)
        } catch (e: Exception) {
            arrayListOf()
        }
    }
}