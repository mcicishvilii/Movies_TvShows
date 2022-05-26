package com.example.movies_tvshows.Fragments.MovieViews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.movies_tvshows.Models.MovieModels.Result1
import com.example.movies_tvshows.R
import com.example.movies_tvshows.databinding.MovieDetailsFragmentBinding


class MoviesDetailsFragment : Fragment(){
    private var _binding: MovieDetailsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MovieDetailsFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultItem = requireArguments().getParcelable<Result1>(MOVIES)


        binding.ivWatchlist.setOnClickListener {
            binding.ivWatchlist.setImageResource(R.drawable.ic_vectorbookmark)
        }



        val movieURL = resultItem?.poster_path
        val realMovieUrl = "https://image.tmdb.org/t/p/w500" + movieURL

        val movieUrlLarge = resultItem?.backdrop_path
        val realMovieLargeUrl = "https://image.tmdb.org/t/p/w500" + movieUrlLarge


        binding.tvMovieName.text = resultItem?.original_title
        binding.tvMovieDescription.text = "Overview: \n\n${resultItem?.overview}"
        binding.tvReleaseDateDetails.text = "Release Date: \n${resultItem?.release_date}"
        binding.tvAverageRatingDetails.text = "Average Rating: \n${resultItem?.vote_average}"
        binding.tvAveragePopularityDetails.text = "Popularity: \n${resultItem?.popularity}"
        binding.tvRateCountDetails.text = "Rate Count: \n${resultItem?.vote_count}"



        Glide.with(requireContext()).load(realMovieLargeUrl).into(binding.ivLargePoster)
        Glide.with(requireContext()).load(realMovieUrl).into(binding.ivSmallPoster)

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


    companion object{
        const val MOVIES = "MOVIES"
        fun newInstance(
            result1: Result1
        ): MoviesDetailsFragment {

            return MoviesDetailsFragment().apply {
                arguments = bundleOf(
                    MOVIES to result1,
                    )
            }
        }
    }

}


