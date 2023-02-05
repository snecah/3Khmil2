package com.example.movies.repository

import com.example.movies.data.AllFilms
import com.example.movies.network.AllFilmsApi
import retrofit2.Response

class MyFilmsRepository {
    suspend fun getMovies(): Response<AllFilms>{
        return AllFilmsApi.retrofitService.getPopularMovie()
    }
}