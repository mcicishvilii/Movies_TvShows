package com.example.movies_tvshows.API

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginResponse<T>(
    @SerializedName("request_login")
    val requestLogin:String
): Parcelable