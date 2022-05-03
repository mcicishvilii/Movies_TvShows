package com.example.movies_tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_tvshows.databinding.MoviesListFragmentBinding

class MovieListFragment : Fragment() {
    private var _binding: MoviesListFragmentBinding? = null

    private val binding get() = _binding!!
    private lateinit var moviesAdapter: MoviesAdapter

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



//        setUpRecyclerView()
//
//        val popularsApi = Retrofit.Builder()
//            .baseUrl("https://api.themoviedb.org/3/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(PopularsApi::class.java)
//
//        CoroutineScope(IO).launch {
//            val response = popularsApi.getPopularMovies("843c612d1207fdec63f0e6a5fd426d68")
//            withContext(Main){
//                moviesAdapter.updateList(response.results)
//            }
//
//        }
    }

    private fun setUpRecyclerView(){
        moviesAdapter = MoviesAdapter(
            mutableListOf()
        ).apply {

        }
        binding.rvMovies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvMovies.adapter = moviesAdapter

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}