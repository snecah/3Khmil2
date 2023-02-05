package com.example.movies.screens.detail

import androidx.lifecycle.*
import com.example.movies.MoviesApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(application: MoviesApplication):AndroidViewModel(application) {
    private var _isFavorite: MutableLiveData<Boolean> = MutableLiveData(false)
    val isFavorite:LiveData<Boolean>
        get() = _isFavorite

    val myFilmsRepository = application.repository
    private var _description: MutableLiveData<String> = MutableLiveData("null")
    val description: LiveData<String>
        get() = _description

    fun getDescription(currentFilmId: Int?){
        viewModelScope.launch(Dispatchers.IO) {
            _description.postValue(myFilmsRepository.getDescription(currentFilmId))
        }
    }
}