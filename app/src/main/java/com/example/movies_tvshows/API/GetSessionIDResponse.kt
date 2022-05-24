package com.example.movies_tvshows.API

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetSessionIDResponse(
    val session_id: String,
    val success: Boolean
):Parcelable