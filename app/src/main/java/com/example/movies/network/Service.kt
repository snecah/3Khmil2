package com.example.movies.network

import com.example.movies.data.AllFilms
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL = "https://kinopoiskapiunofficial.tech/"


//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build()


interface AllFilmsApiService {
    @Headers("X-API-KEY: 2fa9d828-33a2-4b12-ba50-07165898811d")
    @GET("api/v2.2/films/top")
    suspend fun getPopularMovie():Response<AllFilms>

}



object AllFilmsApi {
    val retrofitService: AllFilmsApiService by lazy {
        retrofit.create(AllFilmsApiService::class.java)
    }
}