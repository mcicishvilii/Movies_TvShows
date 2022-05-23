package com.example.movies_tvshows.Fragments.MovieViews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_tvshows.Models.MovieModels.Result1
import com.example.movies_tvshows.REpos.MoviesRepo.MoviesRepo
import kotlinx.coroutines.launch

class MoviesViewModel: ViewModel() {
    private val moviesLiveData = MutableLiveData<List<Result1>>()
    private val moviesRepo = MoviesRepo.getInstance()



    init {
        viewModelScope.launch { // ეს viewModelScope არის ავტომატურად ბექგგრაუნდ სრედი
            moviesLiveData.postValue(moviesRepo.getPopularMovies("843c612d1207fdec63f0e6a5fd426d68").results)
        }
    }

    fun getMoviesLiveData(): LiveData<List<Result1>> {
        return moviesLiveData
    }
}