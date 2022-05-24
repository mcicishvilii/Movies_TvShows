package com.example.movies_tvshows.API

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class LoginResponse(
    @SerializedName("request_token")
    val request_token:String
)