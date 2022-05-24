package com.example.movies_tvshows.REpos.MoviesRepo

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.movies_tvshows.Room.UserDatabase
import com.example.movies_tvshows.Room.UserEntity

class UsersRepo(context:Context) {
    private val database = UserDatabase.getDatabase(context)

    suspend fun insertUser(userEntity: UserEntity){
        database.userDao().insertUser(userEntity)
    }

    suspend fun getAllUsers(): LiveData<List<UserEntity>> {
        return database.userDao().getAll()
    }

    suspend fun deleteBook(userEntity: UserEntity){
        database.userDao().deleteUser(userEntity)
    }

    companion object{
        private var instance: UsersRepo? = null

        fun getInstance(context: Context):UsersRepo{
            return if (instance != null ){
                instance!!
            }else{
                instance = UsersRepo(context)
                instance!!
            }
        }
    }
}
