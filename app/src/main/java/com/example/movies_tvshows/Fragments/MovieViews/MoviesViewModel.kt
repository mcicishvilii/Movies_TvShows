package com.example.movies_tvshows.Fragments.MovieViews

import android.app.Application
import androidx.lifecycle.*
import com.example.movies_tvshows.Models.LoginScreenData.LoginRequestModel
import com.example.movies_tvshows.Models.MovieModels.Result1
import com.example.movies_tvshows.Models.MovieModels.UserIdResponse
import com.example.movies_tvshows.REpos.MoviesRepo.MoviesRepo
import com.example.movies_tvshows.REpos.MoviesRepo.UsersRepo
import com.example.movies_tvshows.Room.UserEntity
import kotlinx.coroutines.launch

class MoviesViewModel(application: Application): AndroidViewModel(application) {
    private val moviesLiveData = MutableLiveData<List<Result1>>()
    private val moviesLiveData1 = MutableLiveData<List<Result1>>()
    private val moviesLiveData2 = MutableLiveData<List<Result1>>()

    private val moviesRepo = MoviesRepo.getInstance()
    private val usersRepo = UsersRepo.getInstance(application)





    init {
        viewModelScope.launch { // ეს viewModelScope არის ავტომატურად ბექგგრაუნდ სრედი
            moviesLiveData.postValue(moviesRepo.getPopularMovies("843c612d1207fdec63f0e6a5fd426d68").results)
        }

        viewModelScope.launch { // ეს viewModelScope არის ავტომატურად ბექგგრაუნდ სრედი
            moviesLiveData1.postValue(moviesRepo.getTopRated("843c612d1207fdec63f0e6a5fd426d68").results)
        }
    }




    fun searchForMovie(query:String): LiveData<List<Result1>> {
        viewModelScope.launch {
            moviesLiveData2.postValue(moviesRepo.searchForMovie("843c612d1207fdec63f0e6a5fd426d68",query).results)
        }
        return moviesLiveData2
    }

    fun getPopularMoviesLiveData(): LiveData<List<Result1>> {
        return moviesLiveData
    }

    fun getTopRatedMoviesLiveData1(): LiveData<List<Result1>> {
        return moviesLiveData1
    }


}