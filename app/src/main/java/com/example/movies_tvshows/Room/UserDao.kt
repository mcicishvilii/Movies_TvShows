package com.example.movies_tvshows.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): LiveData<List<UserEntity>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(userEntity: UserEntity)
    @Query("DELETE FROM  users")
    fun deleteAll()
    @Delete
    fun deleteUser(userEntity: UserEntity)
    @Update
    fun updateUser(userEntity: UserEntity)
}