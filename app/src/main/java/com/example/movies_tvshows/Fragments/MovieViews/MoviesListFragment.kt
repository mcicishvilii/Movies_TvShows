package com.example.movies_tvshows.Fragments.MovieViews

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_tvshows.Fragments.TVshowViews.TVshowsDetailsFragment
import com.example.movies_tvshows.Fragments.TVshowViews.TVshowsViewModel
import com.example.movies_tvshows.Fragments.TVshowViews.TvShowsListFragment
import com.example.movies_tvshows.Fragments.login.LoginFragment
import com.example.movies_tvshows.Models.MovieModels.Result1
import com.example.movies_tvshows.MoviesAdapter
import com.example.movies_tvshows.R
import com.example.movies_tvshows.databinding.MoviesListFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
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

        viewModel.getPopularMoviesLiveData()
        viewModel.getPopularMoviesLiveData().observe(viewLifecycleOwner){
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

        binding.bntPopular.setOnClickListener {
            viewModel.getPopularMoviesLiveData()
            viewModel.getPopularMoviesLiveData().observe(viewLifecycleOwner){
                moviesAdapter.updateList(it)
            }
        }

        binding.bntTopRated.setOnClickListener {
            viewModel.getTopRatedMoviesLiveData1()
            viewModel.getTopRatedMoviesLiveData1().observe(viewLifecycleOwner){
                moviesAdapter.updateList(it)
            }
        }


        binding.ivSearch.setOnClickListener {
            var searchItem = binding.etSearchbar.text.toString()
            viewModel.searchForMovie(searchItem)
            viewModel.searchForMovie(searchItem).observe(viewLifecycleOwner){
                moviesAdapter.updateList(it)
            }
        }



        // შემდეგი 11 ხაზით ვაკეთებ რო როგორცკი ტექსტს დასერჩავ მაშნვე პარალელურად ამოაგდებს შედეგებს მარა არ გამომდის
        // რო ვშლი ბოლო ასოს, იქრაშება აპი.
        
//        binding.etSearchbar.doOnTextChanged { searchItem, start, before, count ->
//            var searchItem = binding.etSearchbar.text.toString()

//            viewModel.searchForMovie(searchItem)
//            viewModel.searchForMovie(searchItem).observe(viewLifecycleOwner){
//                moviesAdapter.updateList(it)
//            }
//
//            if (searchItem.length < 2){
//                binding.etSearchbar.isEnabled = false
//            }
//        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}


