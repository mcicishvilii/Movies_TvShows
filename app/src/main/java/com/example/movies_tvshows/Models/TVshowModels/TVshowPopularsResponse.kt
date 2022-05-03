package com.example.movies_tvshows.Models.TVshowModels

import com.google.gson.annotations.SerializedName

data class TVshowPopularsResponse(
    @SerializedName("page")
    val page:Int,
    @SerializedName("results")
    val results1:List<Result>
)
