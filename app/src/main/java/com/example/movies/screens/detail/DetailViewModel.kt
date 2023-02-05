package com.example.movies.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel:ViewModel() {
    private var _isFavorite: MutableLiveData<Boolean> = MutableLiveData(false)
    val isFavorite:LiveData<Boolean>
        get() = _isFavorite


    fun markAsFavorite() {
        _isFavorite.value = true
    }

    fun unmarkAsFavorite() {
        _isFavorite.value = false
    }
}