package com.example.movies_tvshows.API

import com.example.movies_tvshows.Models.LoginScreenData.LoginRequestModel
import com.example.movies_tvshows.Models.MovieModels.PopularResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RequestTokenApi{
    @GET("authentication/token/new")

    suspend fun getRequestToken(
        @Query("api_key")
        apiKey:String): TokenResponse
}