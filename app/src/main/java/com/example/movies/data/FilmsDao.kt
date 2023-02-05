package com.example.movies.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movies.FILMS_TABLE_NAME

@Dao
interface FilmsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie:Film)

    @Update
    fun update(movie: Film)

    @Query("SELECT * FROM $FILMS_TABLE_NAME")
    fun getAllFilms(): LiveData<List<Film>>
}