package com.example.movies_tvshows.Fragments.TVshowViews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_tvshows.API.PopularTvshowsApi
import com.example.movies_tvshows.Fragments.MovieViews.MoviesListFragment
import com.example.movies_tvshows.Fragments.MovieViews.MoviesViewModel
import com.example.movies_tvshows.Models.TVshowModels.Result
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
    private val viewModel by viewModels<TVshowsViewModel>()

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

        viewModel.getTvshowsLiveData().observe(viewLifecycleOwner){
            tvShowsAdapter.updateList(it)
        }

    }
    private fun setUpRecyclerView() {


        tvShowsAdapter = TvShowsAdapter(
            mutableListOf()
        ).apply {
            setOnItemCLickListener { result:Result, i ->
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.flContent, TVshowsDetailsFragment.newInstance(
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