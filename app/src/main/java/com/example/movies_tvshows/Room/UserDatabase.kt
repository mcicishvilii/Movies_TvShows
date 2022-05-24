package com.example.movies_tvshows.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

const val DATABASE_VERSION = 1

@Database(entities = [UserEntity::class], version = DATABASE_VERSION, exportSchema = false)


abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao():UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null
        fun getDatabase(context: Context):UserDatabase{
            var tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val newInstance = Room.databaseBuilder(context, UserDatabase::class.java, "users_database").allowMainThreadQueries().build()
                INSTANCE = newInstance
                return newInstance
            }
        }
    }
}