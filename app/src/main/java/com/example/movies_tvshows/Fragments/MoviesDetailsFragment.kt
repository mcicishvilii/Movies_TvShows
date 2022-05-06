package com.example.movies_tvshows.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
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
        val movieNamefromCompanionObject = requireArguments().getString(KEY_MOVIE_NAME)
        val movieDescfromCompanionObject = requireArguments().getString(KEY_MOVIE_DESC)
        val movieYearfromCompanionObject = requireArguments().getString(KEY_MOVIE_YEAR)
        val movieRatingfromCompanionObject = requireArguments().getString(KEY_MOVIE_RATING)
        val moviePopularityfromCompanionObject = requireArguments().getString(KEY_MOVIE_POP)
        val movieRatecountfromCompanionObject = requireArguments().getString(KEY_MOVIE_RATECOUNT)

        val movieUrl = requireArguments().getString(MoviesDetailsFragment.KEY_MOVIEL_POST)
        val realMovieUrl = "https://image.tmdb.org/t/p/w500" + movieUrl

        val movieLargeUrl = requireArguments().getString(MoviesDetailsFragment.KEY_MOVIES_POST)
        val realMovieLargeUrl = "https://image.tmdb.org/t/p/w500" + movieLargeUrl

        binding.tvMovieName.text = movieNamefromCompanionObject
        binding.tvMovieDescription.text = "Overview: \n\n${movieDescfromCompanionObject}"
        binding.tvReleaseDateDetails.text = "Release Date: \n${movieYearfromCompanionObject}"
        binding.tvAverageRatingDetails.text = "Average Rating: \n${movieRatingfromCompanionObject}"
        binding.tvAveragePopularityDetails.text = "Popularity: \n${moviePopularityfromCompanionObject}"
        binding.tvRateCountDetails.text = "Rate Count: \n${movieRatecountfromCompanionObject}"



        Glide.with(requireContext()).load(realMovieLargeUrl).into(binding.ivLargePoster)
        Glide.with(requireContext()).load(realMovieUrl).into(binding.ivSmallPoster)

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


    companion object{
        const val KEY_MOVIE_NAME = "KEY_MOVIE_NAME"
        const val KEY_MOVIE_DESC = "KEY_MOVIE_DESC"
        const val KEY_MOVIEL_POST = "KEY_MOVIEL_POST"
        const val KEY_MOVIES_POST = "KEY_MOVIES_POST"
        const val KEY_MOVIE_YEAR = "KEY_MOVIE_YEAR"
        const val KEY_MOVIE_RATING = "KEY_MOVIE_RATING"
        const val KEY_MOVIE_POP = "KEY_MOVIE_POP"
        const val KEY_MOVIE_RATECOUNT = "KEY_MOVIE_RATECOUNT"

        fun newInstance(
            movieName: String,
            movieDesc: String,
            movieImg: String,
            movieImgSMall:String,
            movieReleaseDate:String,
            movieRating: String,
            movieRPopularity:String,
            movieRateCount:String
        ): MoviesDetailsFragment{
            return MoviesDetailsFragment().apply {
                arguments = bundleOf(
                    KEY_MOVIE_NAME to movieName,
                    KEY_MOVIE_DESC to movieDesc,
                    KEY_MOVIEL_POST to movieImg,
                    KEY_MOVIES_POST to movieImgSMall,
                    KEY_MOVIE_YEAR to movieReleaseDate,
                    KEY_MOVIE_RATING to movieRating,
                    KEY_MOVIE_POP to movieRPopularity,
                    KEY_MOVIE_RATECOUNT to movieRateCount

                    )
            }
        }
    }
}


