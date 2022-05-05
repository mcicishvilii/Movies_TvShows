package com.example.movies_tvshows.API


import com.example.movies_tvshows.Models.TVshowModels.TVshowPopularsResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PopularTvshowsApi {
    @Headers("platform: Web")
    @GET("tv/popular")

    suspend fun getPopularTVshows(
        @Query("api_key")
        apiKey:String): TVshowPopularsResponse

//    suspend fun getTVshowDetails(
//        @Query("api_key")
//        apiKey: String):TVshowPopularsResponse
}