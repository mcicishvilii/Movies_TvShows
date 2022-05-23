package com.example.movies_tvshows.Fragments.MovieViews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_tvshows.Fragments.TVshowViews.TVshowsDetailsFragment
import com.example.movies_tvshows.Fragments.TVshowViews.TVshowsViewModel
import com.example.movies_tvshows.Fragments.TVshowViews.TvShowsListFragment
import com.example.movies_tvshows.Models.MovieModels.Result1
import com.example.movies_tvshows.MoviesAdapter
import com.example.movies_tvshows.R
import com.example.movies_tvshows.databinding.MoviesListFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesListFragment : Fragment() {
    private var _binding: MoviesListFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var moviesAdapter: MoviesAdapter
    private val viewModel by viewModels<MoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MoviesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()


        viewModel.getMoviesLiveData()
        viewModel.getMoviesLiveData().observe(viewLifecycleOwner){
            moviesAdapter.updateList(it)
        }
    }

    private fun setUpRecyclerView() {

        moviesAdapter = MoviesAdapter(
            mutableListOf()
        ).apply {
            setOnItemCLickListener { result: Result1, i ->
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.flContent, MoviesDetailsFragment.newInstance(
                        result,
                    )
                    )
                    addToBackStack(TVshowsDetailsFragment::javaClass.name)
                    commit()
                }
            }
        }

        binding.rvMovies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvMovies.adapter = moviesAdapter

        binding.bntTVShows.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flContent, TvShowsListFragment())
                addToBackStack(TvShowsListFragment::javaClass.name)
                commit()
            }
        }

    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}


