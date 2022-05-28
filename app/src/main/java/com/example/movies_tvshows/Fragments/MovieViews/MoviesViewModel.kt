package com.example.movies_tvshows.Fragments.MovieViews

import android.app.Application
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import com.example.movies_tvshows.Fragments.login.LoginVeiwModel
import com.example.movies_tvshows.Models.LoginScreenData.GetSessionIDRequestModel
import com.example.movies_tvshows.Models.LoginScreenData.LoginRequestModel
import com.example.movies_tvshows.Models.MovieModels.AddToWatchlistRequest
import com.example.movies_tvshows.Models.MovieModels.Result1
import com.example.movies_tvshows.Models.MovieModels.UserIdResponse
import com.example.movies_tvshows.MoviesAdapter
import com.example.movies_tvshows.REpos.MoviesRepo.MoviesRepo
import com.example.movies_tvshows.REpos.MoviesRepo.TokenRepo
import com.example.movies_tvshows.REpos.MoviesRepo.UsersRepo
import com.example.movies_tvshows.Room.UserEntity
import kotlinx.coroutines.launch

class MoviesViewModel(application: Application): AndroidViewModel(application) {
    private val moviesLiveData = MutableLiveData<List<Result1>>()
    private val moviesLiveData1 = MutableLiveData<List<Result1>>()
    private val moviesLiveData2 = MutableLiveData<List<Result1>>()
    private val watchlistLiveData = MutableLiveData<List<Result1>>()
    private val moviesRepo = MoviesRepo.getInstance()
    private val tokenRepo = TokenRepo.getInstance(application)




    init {
        viewModelScope.launch { // ეს viewModelScope არის ავტომატურად ბექგგრაუნდ სრედი
            moviesLiveData.postValue(moviesRepo.getPopularMovies("843c612d1207fdec63f0e6a5fd426d68").results)
        }

        viewModelScope.launch { // ეს viewModelScope არის ავტომატურად ბექგგრაუნდ სრედი
            moviesLiveData1.postValue(moviesRepo.getTopRated("843c612d1207fdec63f0e6a5fd426d68").results)
        }
    }

    val apikey = "843c612d1207fdec63f0e6a5fd426d68"
    val sessionID = "6feed1b64fb2d1d294ae52213434a9f66cb1dc47"

    fun addtoWatchlist() {
        viewModelScope.launch {


            tokenRepo.addToWatchlist(
                /*usersRepo.getAllUsers().toString()*/ "12399206",
                addToWatchlistRequest = AddToWatchlistRequest(
                    272,
                    "movie",
                    true
                ),
                apiKey = apikey,
                sessionID = "6feed1b64fb2d1d294ae52213434a9f66cb1dc47"
            )
        }
    }

    fun searchForMovie(query:String): LiveData<List<Result1>> {
        viewModelScope.launch {
            moviesLiveData2.postValue(moviesRepo.searchForMovie("843c612d1207fdec63f0e6a5fd426d68",query).results)
        }
        return moviesLiveData2
    }


    fun getWatchlistList():LiveData<List<Result1>>{
        viewModelScope.launch {
            watchlistLiveData.postValue(moviesRepo.showWatchlist("12399206",apikey,sessionID).results)
        }
        return watchlistLiveData
    }

    fun getPopularMoviesLiveData(): LiveData<List<Result1>> {
        return moviesLiveData
    }

    fun getTopRatedMoviesLiveData1(): LiveData<List<Result1>> {
        return moviesLiveData1
    }


}