package com.example.movies_tvshows.Fragments

import android.database.CursorJoiner
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
import com.example.movies_tvshows.Models.TVshowModels.Result
import com.example.movies_tvshows.MoviesAdapter
import com.example.movies_tvshows.R
import com.example.movies_tvshows.TvShowsAdapter
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
    private lateinit var tvShowsAdapter: TvShowsAdapter

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
            val response = PopularTvshowsApi.getPopularTVshows("843c612d1207fdec63f0e6a5fd426d68")
            withContext(Main){
                tvShowsAdapter.updateList(response.results1)
            }
        }
    }
    private fun setUpRecyclerView() {


//        tvShowsAdapter = TvShowsAdapter(
//            mutableListOf()
//        ).apply {
//            setOnItemCLickListener { result:Result, i ->
//                parentFragmentManager.beginTransaction().apply {
//                    replace(R.id.flContent,TVshowsDetailsFragment.newInstance(
//                        result.name,
//                        result.overview,
//                        result.poster_path,
//                        result.backdrop_path,
//                        result.first_air_date,
//                        result.vote_average.toString(),
//                        result.popularity.toString(),
//                        result.vote_count.toString(),
//                    ))
//                    addToBackStack(TVshowsDetailsFragment::javaClass.name)
//                    commit()
//                }
//            }
//        }




        binding.rvMovies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvMovies.adapter = tvShowsAdapter

            binding.bntMovies.setOnClickListener {
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.flContent, MoviesListFragment())
                    addToBackStack(MoviesListFragment::javaClass.name)
                    commit()
                }
            }
        }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}