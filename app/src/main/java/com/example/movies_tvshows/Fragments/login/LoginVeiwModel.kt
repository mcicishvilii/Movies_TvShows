package com.example.movies_tvshows.Fragments.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_tvshows.Fragments.TVshowViews.TVshowsDetailsFragment
import com.example.movies_tvshows.Models.LoginScreenData.LoginRequestModel
import com.example.movies_tvshows.Models.MovieModels.Result1
import com.example.movies_tvshows.Models.TVshowModels.Result
import com.example.movies_tvshows.REpos.MoviesRepo.TokenRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginVeiwModel(private val repo: TokenRepo): ViewModel() {

    var myResponse: MutableLiveData<Response<LoginRequestModel>> = MutableLiveData()

    fun getToken() {
        viewModelScope.launch {
            val response = repo.miigeTokeni("843c612d1207fdec63f0e6a5fd426d68")
            myResponse.value = response
        }

    }


    fun pushLogin(loginRequestModel: LoginRequestModel) {
        viewModelScope.launch {
            val response = repo.gaeciLoginDetalebi("843c612d1207fdec63f0e6a5fd426d68",loginRequestModel)
            myResponse.value = response
        }

    }


}