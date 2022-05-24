package com.example.movies_tvshows.helpers

import com.example.movies_tvshows.API.LoginApi
import com.example.movies_tvshows.API.PopularTvshowsApi
import com.example.movies_tvshows.API.PopularsApi
import com.example.movies_tvshows.API.RequestTokenApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val PopularuliMovieApi = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PopularsApi::class.java)

    val PopularuliTVshowApi = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PopularTvshowsApi::class.java)

    val RequestisTokenApi = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RequestTokenApi::class.java)

    val LoginisApi = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(LoginApi::class.java)

}

