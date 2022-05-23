package com.example.movies_tvshows.REpos.MoviesRepo

import com.example.movies_tvshows.Models.MovieModels.PopularResponse
import com.example.movies_tvshows.helpers.RetrofitHelper

class MoviesRepo {
    suspend fun getPopularMovies(apiKey: String):PopularResponse{
        return RetrofitHelper.PopularuliMovieApi.getPopularMovies(apiKey)
    }

    companion object {
        //this singleton
        private var instance: MoviesRepo? = null
        fun getInstance(): MoviesRepo {
            return if (instance != null) {
                instance!!
            } else {
                instance = MoviesRepo()
                instance!!
            }
        }

    }
}