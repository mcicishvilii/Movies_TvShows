package com.example.movies_tvshows.API

import com.example.movies_tvshows.Models.PopularResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularsApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        apiKey:String): PopularResponse
}
