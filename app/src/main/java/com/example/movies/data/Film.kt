package com.example.movies.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movies.FILMS_TABLE_NAME
import java.io.Serializable
@Entity(tableName = FILMS_TABLE_NAME)
data class Film(
    @PrimaryKey
    val filmId: Int,
    val countries: List<Country>,
    val filmLength: String?,
    val genres: List<Genre>,
    val nameEn: String?,
    val nameRu: String,
    val posterUrl: String,
    val posterUrlPreview: String?,
    val rating: String?,
    val ratingVoteCount: Int?,
    val year: String
)