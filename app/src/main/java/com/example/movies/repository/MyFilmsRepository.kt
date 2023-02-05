package com.example.movies.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.movies.data.Film
import com.example.movies.data.FilmsDao
import com.example.movies.network.AllFilmsApi

class MyFilmsRepository(private val filmsDao: FilmsDao) {
    @WorkerThread
    suspend fun getMovies(): List<Film>?{
        val localFilmsInfo = filmsDao.getAllFilms()
        Log.e("@@@",localFilmsInfo.value.toString())
        if (localFilmsInfo.value.isNullOrEmpty()) {
            val apiFilmsInfo = AllFilmsApi.retrofitService.getPopularMovie().body()?.films
            Log.e("@@@",apiFilmsInfo.toString())
            apiFilmsInfo?.forEach {
                filmsDao.insert(it)
            }
            return apiFilmsInfo
        } else {
            Log.e("@@@",localFilmsInfo.value.toString())
            return localFilmsInfo.value
        }
    }
    @WorkerThread
    suspend fun getDescription(filmId: Int?):String {
        return AllFilmsApi.retrofitService.getManyFilmProperties(filmId).body()!!.description
    }
}