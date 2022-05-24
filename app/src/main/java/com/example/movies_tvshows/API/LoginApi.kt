package com.example.movies_tvshows.API

import com.example.movies_tvshows.Fragments.login.LoginFragment
import com.example.movies_tvshows.Models.LoginScreenData.GetSessionIDRequestModel

import com.example.movies_tvshows.Models.LoginScreenData.LoginRequestModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginApi {
    @POST("authentication/token/validate_with_login")

    suspend fun logInWithUserName(
        @Query("api_key")
        apiKey: String,
        @Body loginRequestModel: LoginRequestModel
    )
            :LoginResponse

    @POST("authentication/session/new")

    suspend fun getSessionId(
        @Query("api_key")
        apiKey: String,
        @Body getSessionIDRequestModel: GetSessionIDRequestModel
    )
            :GetSessionIDResponse
}