package com.example.movies_tvshows.Models.MovieModels

data class UserIdResponse(
    val avatar: Avatar,
    val id: List<UserIdResponse>, // ეს მჭირდება
    val include_adult: Boolean,
    val iso_3166_1: String,
    val iso_639_1: String,
    val name: String,
    val username: String
)