package com.example.movies_tvshows.Models.MovieModels

import com.google.gson.annotations.SerializedName

data class PopularResponse(
    @SerializedName("page")
    val page:Int,
    @SerializedName("results")
    val results:List<MovieItem>
)
