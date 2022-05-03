package com.example.movies_tvshows.API


import com.example.movies_tvshows.Models.TVshowModels.TVshowPopularsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularTvshowsApi {
    @GET("tv/popular")

    suspend fun getPopularTVshows(
        @Query("api_key")
        apiKey:String): TVshowPopularsResponse
}