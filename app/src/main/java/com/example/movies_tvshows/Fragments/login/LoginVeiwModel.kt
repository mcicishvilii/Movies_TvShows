package com.example.movies_tvshows.Fragments.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.movies_tvshows.API.GetSessionIDResponse
import com.example.movies_tvshows.Fragments.TVshowViews.TVshowsDetailsFragment
import com.example.movies_tvshows.Models.LoginScreenData.GetSessionIDRequestModel
import com.example.movies_tvshows.Models.LoginScreenData.LoginRequestModel
import com.example.movies_tvshows.Models.MovieModels.Result1
import com.example.movies_tvshows.Models.MovieModels.UserIdResponse
import com.example.movies_tvshows.Models.TVshowModels.Result
import com.example.movies_tvshows.REpos.MoviesRepo.TokenRepo
import com.example.movies_tvshows.REpos.MoviesRepo.UsersRepo
import com.example.movies_tvshows.Room.UserEntity
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

class LoginVeiwModel(application: Application): AndroidViewModel(application) {

    private var tokenliveData = MutableLiveData<String>()
    private val usersRepo = UsersRepo.getInstance(application)
    private val tokenRepo = TokenRepo.getInstance(application)
    private var requestTokeni:String = ""
    private var gacematokeni:String = "misho"
    private val userIdLiveData = MutableLiveData<List<UserIdResponse>>()
    private var misho = ""


    init {
        viewModelScope.launch {
            requestTokeni = tokenRepo.miigeTokeni("843c612d1207fdec63f0e6a5fd426d68").request_token
        }


    }


    fun getTokenLiveData(): LiveData<String> {
        return tokenliveData
    }

    fun logIn(user:String, password:String) { // ეს აგზავნის იუზერს და პაროლს რომელსაც ხელით შევიყვან ლოგინფრაგმენტში
        viewModelScope.launch {
            gacematokeni = tokenRepo.logIn(
                "843c612d1207fdec63f0e6a5fd426d68",
                loginRequestModel = LoginRequestModel(user,password,requestTokeni)).request_token
            tokenliveData.postValue(gacematokeni)
        }
    }


    fun getSessionId(requestToken:String){ // ეს პოსტავს logIn ფუნქციის გაგზავნით მიღებულ ტოკენს და უკან აბრუნებს სესსიონ აიდს.
        viewModelScope.launch {
            gacematokeni
            val sessionID = tokenRepo.getSessionId("843c612d1207fdec63f0e6a5fd426d68", getSessionIDRequestModel =
            GetSessionIDRequestModel(requestToken)
            )
            tokenRepo.saveAccessToken(sessionID.session_id)
            misho = sessionID.toString()
        }

    }

    fun getUserId(query:String): LiveData<List<UserIdResponse>> {
        viewModelScope.launch {
            userIdLiveData.postValue(tokenRepo.getUserIdFromSessionId("843c612d1207fdec63f0e6a5fd426d68",misho).id)
        }
        return userIdLiveData
    }
}
