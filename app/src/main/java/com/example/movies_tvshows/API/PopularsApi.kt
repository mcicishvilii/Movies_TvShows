package com.example.movies_tvshows.API

import com.example.movies_tvshows.Models.MovieModels.PopularResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PopularsApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        apiKey:String): PopularResponse

    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("api_key")
        apiKey:String): PopularResponse


    @GET ("search/movie")
    suspend fun  searchMovie(
        @Query("api_key") apiKey:String,
        @Query ("query") query:String):PopularResponse
}
