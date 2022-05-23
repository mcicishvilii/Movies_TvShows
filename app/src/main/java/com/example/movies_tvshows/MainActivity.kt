package com.example.movies_tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies_tvshows.Fragments.login.LoginFragment
import com.example.movies_tvshows.databinding.ActivityMainBinding
import com.facebook.drawee.backends.pipeline.Fresco


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Fresco.initialize(this)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flContent, LoginFragment())
            addToBackStack(LoginFragment::javaClass.name)
            commit()
        }

    }
}
