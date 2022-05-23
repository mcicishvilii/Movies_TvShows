package com.example.movies_tvshows.REpos.MoviesRepo

import com.example.movies_tvshows.API.LoginResponse
import com.example.movies_tvshows.API.TokenResponse
import com.example.movies_tvshows.Fragments.login.LoginFragment
import com.example.movies_tvshows.Models.LoginScreenData.LoginRequestModel
import com.example.movies_tvshows.helpers.RetrofitHelper
import retrofit2.Response

class TokenRepo {

    suspend fun miigeTokeni(apiKey: String): Response<LoginRequestModel> {
        return RetrofitHelper.RequestisTokenApi.getRequestToken(apiKey)
    }

    suspend fun gaeciLoginDetalebi(apiKey: String,loginRequestModel: LoginRequestModel):Response<LoginRequestModel>{
        return RetrofitHelper.RequestisTokenApi.logInWithUserName(apiKey,loginRequestModel)
    }




    companion object {
        //this singleton
        private var instance: TokenRepo? = null
        fun getInstance(): TokenRepo {
            return if (instance != null) {
                instance!!
            } else {
                instance = TokenRepo()
                instance!!
            }
        }

    }
}