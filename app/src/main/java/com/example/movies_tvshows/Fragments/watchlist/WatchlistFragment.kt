package com.example.movies_tvshows.Fragments.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_tvshows.Fragments.MovieViews.MoviesDetailsFragment
import com.example.movies_tvshows.Fragments.MovieViews.MoviesViewModel
import com.example.movies_tvshows.Fragments.TVshowViews.TVshowsDetailsFragment
import com.example.movies_tvshows.Models.MovieModels.Result1
import com.example.movies_tvshows.MoviesAdapter
import com.example.movies_tvshows.R
import com.example.movies_tvshows.databinding.MoviesListFragmentBinding
import com.example.movies_tvshows.databinding.WatchlistLayoutBinding

class WatchlistFragment: Fragment() {
    private var _binding: WatchlistLayoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var watchlistAdapter: WatchlistAdapter
    private val viewModel by viewModels<MoviesViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = WatchlistLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()



    }

    fun setUpRecyclerView(){

        watchlistAdapter = WatchlistAdapter(mutableListOf()).apply {

        }

        binding.rvList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvList.adapter = watchlistAdapter

        viewModel.getWatchlistList()
        viewModel.getWatchlistList().observe(viewLifecycleOwner){
            watchlistAdapter.updateList(it)
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}