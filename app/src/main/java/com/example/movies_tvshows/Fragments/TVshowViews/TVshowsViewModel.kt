package com.example.movies_tvshows.Fragments.TVshowViews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_tvshows.Models.MovieModels.Result1
import com.example.movies_tvshows.Models.TVshowModels.Result
import com.example.movies_tvshows.REpos.MoviesRepo.MoviesRepo
import com.example.movies_tvshows.REpos.MoviesRepo.TvShowRepo
import kotlinx.coroutines.launch


    class TVshowsViewModel: ViewModel() {
        private val tvShowLiveData = MutableLiveData<List<Result>>()
        private val tvShowRepo = TvShowRepo.getInstance()

        init {
            viewModelScope.launch { // ეს viewModelScope არის ავტომატურად ბექგგრაუნდ სრედი
                tvShowLiveData.postValue(tvShowRepo.getPopularTvShows("843c612d1207fdec63f0e6a5fd426d68").results1)
            }

        }

        fun getTvshowsLiveData(): LiveData<List<Result>> {
            return tvShowLiveData
        }
    }
