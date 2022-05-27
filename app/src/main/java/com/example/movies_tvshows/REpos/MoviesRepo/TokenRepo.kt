package com.example.movies_tvshows.REpos.MoviesRepo

import android.app.Application
import com.example.movies_tvshows.API.GetSessionIDResponse
import com.example.movies_tvshows.API.LoginResponse
import com.example.movies_tvshows.API.TokenResponse
import com.example.movies_tvshows.Fragments.login.AddUserViewModel
import com.example.movies_tvshows.Fragments.login.LoginFragment
import com.example.movies_tvshows.Fragments.login.LoginVeiwModel
import com.example.movies_tvshows.Models.LoginScreenData.GetSessionIDRequestModel
import com.example.movies_tvshows.Models.LoginScreenData.LoginRequestModel
import com.example.movies_tvshows.Models.MovieModels.AddToWatchlistRequest
import com.example.movies_tvshows.Models.MovieModels.AddToWatchlistResponse
import com.example.movies_tvshows.Models.MovieModels.UserIdResponse
import com.example.movies_tvshows.Room.UserDatabase
import com.example.movies_tvshows.helpers.RetrofitHelper
import retrofit2.Response

class TokenRepo(val application: Application) {

    var loginViewModel = LoginVeiwModel(application)
    var userDatabase = UserDatabase
    var usersRepo = UsersRepo
    var addUserViewModel = AddUserViewModel(application)

    suspend fun miigeTokeni(apiKey: String): TokenResponse {
        return RetrofitHelper.RequestisTokenApi.getRequestToken(apiKey)
    }

    suspend fun logIn(apiKey: String, loginRequestModel: LoginRequestModel): LoginResponse {
        return RetrofitHelper.LoginisApi.logInWithUserName(apiKey,loginRequestModel)
    }

    suspend fun getSessionId(apiKey: String,getSessionIDRequestModel: GetSessionIDRequestModel): GetSessionIDResponse {
        return RetrofitHelper.LoginisApi.getSessionId(apiKey,getSessionIDRequestModel)
    }

    suspend fun addToWatchlist(apiKey: String,addToWatchlistRequest: AddToWatchlistRequest): AddToWatchlistResponse {
        return RetrofitHelper.LoginisApi.addToWatchlist(
            addUserViewModel.getAllUsers().toString(),
            apiKey,
            loginViewModel.getSessionId(loginViewModel.requestTokeni).toString(),
            addToWatchlistRequest)
    }

    fun saveAccessToken(sessionID:String){ // ეს არის შეარდ პრეფერენსი რაც დავალებაში წერია
        val sharedPreference = application.getSharedPreferences("TOKENPREFERENCE", Application.MODE_PRIVATE)
        sharedPreference.edit().putString("TOKEN_KEY",sessionID).apply()
    }

    fun getsessionId():String?{
        val sharedPreference = application.getSharedPreferences("TOKENPREFERENCE", Application.MODE_PRIVATE)
        return sharedPreference.getString("TOKEN_KEY","no session id")
    }

    suspend fun getUserIdFromSessionId(apiKey: String, sessionIdHere:String): UserIdResponse {
        return RetrofitHelper.PopularuliMovieApi.getUserId(apiKey,sessionIdHere)
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