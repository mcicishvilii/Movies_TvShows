package com.example.movies_tvshows.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_tvshows.API.PopularTvshowsApi
import com.example.movies_tvshows.API.PopularsApi
import com.example.movies_tvshows.MoviesAdapter
import com.example.movies_tvshows.R
import com.example.movies_tvshows.databinding.TvShowsListFragmentBinding

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TvShowsListFragment : Fragment() {
    private var _binding: TvShowsListFragmentBinding? = null

    private val binding get() = _binding!!
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TvShowsListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()



        val PopularTvshowsApi = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PopularTvshowsApi::class.java)

        CoroutineScope(IO).launch {
            val response = PopularTvshowsApi.getPopularMovies("843c612d1207fdec63f0e6a5fd426d68")
            withContext(Main){
                moviesAdapter.updateList(response.results)
            }

        }

    }

    private fun setUpRecyclerView() {
        moviesAdapter = MoviesAdapter(
            mutableListOf()
        ).apply {

        }
        binding.rvMovies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvMovies.adapter = moviesAdapter

        binding.bntMovies.setOnClickListener {
            // აქ უნდა გადავიყვანო ამავე კლასში ფილმების სიის ფრაგმენტში

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flContent, MoviesListFragment())
                addToBackStack(MoviesListFragment::javaClass.name)
                commit()
            }

            binding.bntMovies.setOnClickListener {
                // აქ უნდა გადავიყვანო ტვშოუების კლასში - ტვშოუ სიის ფრაგმენტში

                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.flContent, MoviesListFragment())
                    addToBackStack(MoviesListFragment::javaClass.name)
                    commit()
                }
            }
        }
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}