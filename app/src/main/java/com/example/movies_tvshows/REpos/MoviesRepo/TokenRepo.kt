package com.example.movies_tvshows.REpos.MoviesRepo

import android.app.Application
import com.example.movies_tvshows.API.GetSessionIDResponse
import com.example.movies_tvshows.API.LoginResponse
import com.example.movies_tvshows.API.TokenResponse
import com.example.movies_tvshows.Fragments.login.LoginFragment
import com.example.movies_tvshows.Models.LoginScreenData.GetSessionIDRequestModel
import com.example.movies_tvshows.Models.LoginScreenData.LoginRequestModel
import com.example.movies_tvshows.helpers.RetrofitHelper
import retrofit2.Response

class TokenRepo(val application: Application) {

    suspend fun miigeTokeni(apiKey: String): TokenResponse {
        return RetrofitHelper.RequestisTokenApi.getRequestToken(apiKey)
    }

    suspend fun logIn(apiKey: String, loginRequestModel: LoginRequestModel): LoginResponse {
        return RetrofitHelper.LoginisApi.logInWithUserName(apiKey,loginRequestModel)
    }

    suspend fun getSessionId(apiKey: String,getSessionIDRequestModel: GetSessionIDRequestModel): GetSessionIDResponse {
        return RetrofitHelper.LoginisApi.getSessionId(apiKey,getSessionIDRequestModel)
    }

    fun saveAccessToken(sessionID:String){
        val sharedPreference = application.getSharedPreferences("TOKENPREFERENCE", Application.MODE_PRIVATE)
        sharedPreference.edit().putString("TOKEN_KEY",sessionID).apply()
    }

    fun getsessionId():String?{
        val sharedPreference = application.getSharedPreferences("TOKENPREFERENCE", Application.MODE_PRIVATE)
        return sharedPreference.getString("TOKEN_KEY","no session id")
    }


    companion object {
        //this singleton
        private var instance: TokenRepo? = null
        fun getInstance(application: Application): TokenRepo {
            return if (instance != null) {
                instance!!
            } else {
                instance = TokenRepo(application)
                instance!!
            }
        }

    }
}