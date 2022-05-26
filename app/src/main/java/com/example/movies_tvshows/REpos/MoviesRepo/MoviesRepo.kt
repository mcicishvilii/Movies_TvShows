package com.example.movies_tvshows.REpos.MoviesRepo

import com.example.movies_tvshows.Models.MovieModels.PopularResponse
import com.example.movies_tvshows.Models.MovieModels.UserIdResponse
import com.example.movies_tvshows.helpers.RetrofitHelper

class MoviesRepo {
    suspend fun getPopularMovies(apiKey: String):PopularResponse{
        return RetrofitHelper.PopularuliMovieApi.getPopularMovies(apiKey)
    }
    suspend fun getTopRated(apiKey: String):PopularResponse{
        return RetrofitHelper.PopularuliMovieApi.getTopRated(apiKey)
    }
    suspend fun searchForMovie(apiKey: String, query:String):PopularResponse{
        return RetrofitHelper.PopularuliMovieApi.searchMovie(apiKey,query)
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