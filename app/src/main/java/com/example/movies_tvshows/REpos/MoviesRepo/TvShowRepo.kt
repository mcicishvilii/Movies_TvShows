package com.example.movies_tvshows.REpos.MoviesRepo

import com.example.movies_tvshows.Models.MovieModels.PopularResponse
import com.example.movies_tvshows.Models.TVshowModels.TVshowPopularsResponse
import com.example.movies_tvshows.helpers.RetrofitHelper

class TvShowRepo {
    suspend fun getPopularTvShows(apiKey: String): TVshowPopularsResponse {
        return RetrofitHelper.PopularuliTVshowApi.getPopularTVshows(apiKey)
    }

    companion object {
        //this singleton
        private var instance: TvShowRepo? = null
        fun getInstance(): TvShowRepo {
            return if (instance != null) {
                instance!!
            } else {
                instance = TvShowRepo()
                instance!!
            }
        }

    }


}