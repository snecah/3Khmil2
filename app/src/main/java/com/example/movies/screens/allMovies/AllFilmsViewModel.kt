package com.example.movies.screens.allMovies
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movies.MoviesApplication
import com.example.movies.data.Film
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllFilmsViewModel(application: MoviesApplication):AndroidViewModel(application) {

    private val myFilmsRepository = application.repository
    private var _myMovies: MutableLiveData<List<Film>> = MutableLiveData()
    val myMovies: LiveData<List<Film>>
        get() = _myMovies

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            _myMovies.postValue(myFilmsRepository.getMovies())
        }
    }
}