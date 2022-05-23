package com.example.movies_tvshows.API

import android.os.Parcelable
import com.example.movies_tvshows.Models.LoginScreenData.LoginRequestModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class TokenResponse(
    @SerializedName("requestToken")
    val requestToken:List<String>
)