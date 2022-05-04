package com.example.movies_tvshows.Models.MovieModels

data class MovieItems(
    val page: Int,
    val results: List<Result1>,
    val total_pages: Int,
    val total_results: Int
)