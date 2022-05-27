package com.example.movies_tvshows.API

import com.example.movies_tvshows.Fragments.login.LoginFragment
import com.example.movies_tvshows.Models.LoginScreenData.GetSessionIDRequestModel

import com.example.movies_tvshows.Models.LoginScreenData.LoginRequestModel
import com.example.movies_tvshows.Models.MovieModels.AddToWatchlistRequest
import com.example.movies_tvshows.Models.MovieModels.AddToWatchlistResponse
import retrofit2.http.*

interface LoginApi {
    @POST("authentication/token/validate_with_login")

    suspend fun logInWithUserName(
        @Query("api_key")
        apiKey: String,
        @Body loginRequestModel: LoginRequestModel
    ):LoginResponse

    @POST("authentication/session/new")

    suspend fun getSessionId(
        @Query("api_key")
        apiKey: String,
        @Body getSessionIDRequestModel: GetSessionIDRequestModel
    ):GetSessionIDResponse


    @POST("account/{accountId}/watchlist")
    suspend fun addToWatchlist(
        @Path("accountId")
        accountId:String,
        @Query("api_key")
        apiKey: String,
        @Query("session_id")
        session_id: String,
        @Body requestModel: AddToWatchlistRequest
    ):AddToWatchlistResponse
}