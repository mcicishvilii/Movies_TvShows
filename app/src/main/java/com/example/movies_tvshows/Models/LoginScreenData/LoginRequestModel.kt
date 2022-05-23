package com.example.movies_tvshows.Models.LoginScreenData

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class LoginRequestModel(
    val username:String,
    val password:String,
    val request_token:String

)
