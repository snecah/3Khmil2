package com.example.movies

import android.app.Application
import com.example.movies.data.FilmsDatabase
import com.example.movies.repository.MyFilmsRepository

class MoviesApplication : Application() {
    val database by lazy { FilmsDatabase.getDatabase(this) }
    val repository by lazy { MyFilmsRepository(database.filmsDao()) }
}