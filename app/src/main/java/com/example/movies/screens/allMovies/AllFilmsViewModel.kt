package com.example.movies.screens.allMovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.AllFilms
import com.example.movies.repository.MyFilmsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AllFilmsViewModel:ViewModel() {

    private val myFilmsRepository = MyFilmsRepository()
    private var _myMovies: MutableLiveData<Response<AllFilms>> = MutableLiveData()
    val myMovies: LiveData<Response<AllFilms>>
        get() = _myMovies

    fun getMovies() {
        viewModelScope.launch {
            _myMovies.value = myFilmsRepository.getMovies()
        }
    }



}