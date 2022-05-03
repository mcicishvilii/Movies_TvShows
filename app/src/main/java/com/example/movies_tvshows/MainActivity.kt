package com.example.movies_tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies_tvshows.Fragments.MoviesListFragment
import com.example.movies_tvshows.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        Fresco.initialize(this)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flContent, MoviesListFragment())
            addToBackStack(MoviesListFragment::javaClass.name)
            commit()
        }

    }
}
