package com.example.movies_tvshows.Fragments.TVshowViews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.movies_tvshows.Models.MovieModels.Result1
import com.example.movies_tvshows.Models.TVshowModels.Result
import com.example.movies_tvshows.databinding.TvShowsDetailsFragmentBinding

class TVshowsDetailsFragment :Fragment(){
    private var _binding:TvShowsDetailsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TvShowsDetailsFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultItem = requireArguments().getParcelable<Result>(TVSHOWS)

        val tvshowURL = resultItem?.poster_path
        val realMovieUrl = "https://image.tmdb.org/t/p/w500" + tvshowURL

        val tvshowUrlLarge = resultItem?.backdrop_path
        val realMovieLargeUrl = "https://image.tmdb.org/t/p/w500" + tvshowUrlLarge

        binding.tvMovieName.text = resultItem?.name
        binding.tvMovieDescription.text = "Overview: \n\n${resultItem?.overview}"
        binding.tvReleaseDateDetails.text = "Release Date: \n${resultItem?.first_air_date}"
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
        const val TVSHOWS = "TVSHOWS"
        fun newInstance(
            result: Result,
            ) : TVshowsDetailsFragment {
            return TVshowsDetailsFragment().apply {
                arguments = bundleOf(
                    TVSHOWS to result,
                )
            }
        }
    }
}


