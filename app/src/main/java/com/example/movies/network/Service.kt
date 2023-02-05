package com.example.movies.network

import com.example.movies.data.AllFilms
import com.example.movies.data.manyFilmProperties
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

private const val BASE_URL = "https://kinopoiskapiunofficial.tech/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build()


interface AllFilmsApiService {
    @Headers("X-API-KEY: 3e5483fd-1675-4675-bf51-774602af3316")
    @GET("api/v2.2/films/top")
    suspend fun getPopularMovie():Response<AllFilms>

    @Headers("X-API-KEY: 3e5483fd-1675-4675-bf51-774602af3316")
    @GET("api/v2.2/films/{id}")
    suspend fun getManyFilmProperties(@Path("id") filmId : Int?):Response<manyFilmProperties>

}



object AllFilmsApi {
    val retrofitService: AllFilmsApiService by lazy {
        retrofit.create(AllFilmsApiService::class.java)
    }
}