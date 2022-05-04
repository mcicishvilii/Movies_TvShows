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
        val movieImgfromCompanionObject = requireArguments().getString(KEY_MOVIE_IMG)

        binding.tvMovieName.text = movieNamefromCompanionObject
        binding.tvMovieDescription.text = movieDescfromCompanionObject
        val movieUrl = requireArguments().getString(KEY_MOVIE_IMG)
        Glide.with(requireContext()).load(movieUrl).into(binding.ivLargePoster)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


    companion object{
        const val KEY_MOVIE_NAME = "KEY_MOVIE_NAME"
        const val KEY_MOVIE_DESC = "KEY_MOVIE_DESC"
        const val KEY_MOVIE_IMG = "KEY_MOVIE_IMG"
        fun newInstance(movieName: String, movieDesc: String, movieImg: String): MoviesDetailsFragment{
            return MoviesDetailsFragment().apply {
                arguments = bundleOf(KEY_MOVIE_NAME to movieName, KEY_MOVIE_DESC to movieDesc,KEY_MOVIE_IMG to movieImg)
            }
        }
    }
}


