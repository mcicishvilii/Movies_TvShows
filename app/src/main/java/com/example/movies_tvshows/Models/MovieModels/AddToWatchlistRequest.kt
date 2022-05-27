package com.example.movies_tvshows.Models.MovieModels

data class AddToWatchlistRequest(
    val media_id: Int,
    val media_type: String,
    val watchlist: Boolean
)