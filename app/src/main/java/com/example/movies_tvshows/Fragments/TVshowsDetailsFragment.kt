package com.example.movies_tvshows.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
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
        // იგივე კომენტარი მაქვს რაც კინოებისს დეტალებზე  + ყველაზე კარგი იქნებოდა მხოლოოდ id გადმოგეცა და მერე ამ ფრაგმენტშიც ვებსერვისით გადმოგეწერა ინფოო

        super.onViewCreated(view, savedInstanceState)
        val movieNamefromCompanionObject = requireArguments().getString(TVshowsDetailsFragment.KEY_TVSHOW_NAME)
        val movieDescfromCompanionObject = requireArguments().getString(TVshowsDetailsFragment.KEY_TVSHOW_DESC)
        val movieYearfromCompanionObject = requireArguments().getString(TVshowsDetailsFragment.KEY_TVSHOW_YEAR)
        val movieRatingfromCompanionObject = requireArguments().getString(TVshowsDetailsFragment.KEY_MTVSHOW_RATING)
        val moviePopularityfromCompanionObject = requireArguments().getString(TVshowsDetailsFragment.KEY_TVSHOW_POP)
        val movieRatecountfromCompanionObject = requireArguments().getString(TVshowsDetailsFragment.KEY_TVSHOW_RATECOUNT)

        val movieUrl = requireArguments().getString(TVshowsDetailsFragment.KEY_TVSHOWL_POST)
        val realMovieUrl = "https://image.tmdb.org/t/p/w500" + movieUrl

        val movieLargeUrl = requireArguments().getString(TVshowsDetailsFragment.KEY_TVSHOWS_POST)
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
        const val KEY_TVSHOW_NAME = "KEY_TVSHOW_NAME"
        const val KEY_TVSHOW_DESC = "KEY_TVSHOW_DESC"
        const val KEY_TVSHOWL_POST = "KEY_TVSHOWL_POST"
        const val KEY_TVSHOWS_POST = "KEY_TVSHOWS_POST"
        const val KEY_TVSHOW_YEAR = "KEY_TVSHOW_YEAR"
        const val KEY_MTVSHOW_RATING = "KEY_MTVSHOW_RATING"
        const val KEY_TVSHOW_POP = "KEY_TVSHOW_POP"
        const val KEY_TVSHOW_RATECOUNT = "KEY_TVSHOW_RATECOUNT"

        fun newInstance(
            tvShowName: String,
            tvShowDesc: String,
            tvShowImg: String,
            tvShowImgSMall:String,
            tvShowReleaseDate:String,
            tvShowRating: String,
            tvShowRPopularity:String,
            tvShowRateCount:String) :TVshowsDetailsFragment{
            return TVshowsDetailsFragment().apply {
                arguments = bundleOf(
                    KEY_TVSHOW_NAME to tvShowName,
                    KEY_TVSHOW_DESC to tvShowDesc,
                    KEY_TVSHOWL_POST to tvShowImg,
                    KEY_TVSHOWS_POST to tvShowImgSMall,
                    KEY_TVSHOW_YEAR to tvShowReleaseDate,
                    KEY_MTVSHOW_RATING to tvShowRating,
                    KEY_TVSHOW_POP to tvShowRPopularity,
                    KEY_TVSHOW_RATECOUNT to tvShowRateCount
                )
            }
        }
    }
}


