package com.example.movies_tvshows.Fragments.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_tvshows.REpos.MoviesRepo.UsersRepo
import com.example.movies_tvshows.Room.UserEntity
import kotlinx.coroutines.launch

class AddUserViewModel(application: Application): AndroidViewModel(application){

    private val usersRepo = UsersRepo.getInstance(application)

    fun saveUser(user: UserEntity){
        viewModelScope.launch {
            usersRepo.saveUser(user)
        }
    }

    fun getAllUsers(){
        viewModelScope.launch {
            usersRepo.getAllUsers()
        }
    }
}