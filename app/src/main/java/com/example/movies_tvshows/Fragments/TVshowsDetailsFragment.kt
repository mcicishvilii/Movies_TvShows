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
        super.onViewCreated(view, savedInstanceState)
        val tvShowNamefromCompanionObject = requireArguments().getString(KEY_TVSHOW_NAME)
        val tvShowDescfromCompanionObject = requireArguments().getString(KEY_TVSHOW_DESC)

        binding.tvMovieName.text = tvShowNamefromCompanionObject
        binding.tvMovieDescription.text = tvShowDescfromCompanionObject
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


    companion object{
        const val KEY_TVSHOW_NAME = "KEY_TVSHOW_NAME"
        const val KEY_TVSHOW_DESC = "KEY_TVSHOW_DESC"
        fun newInstance(tvShowName: String, tvShowDesc: String) :TVshowsDetailsFragment{
            return TVshowsDetailsFragment().apply {
                arguments = bundleOf(KEY_TVSHOW_NAME to tvShowName, KEY_TVSHOW_DESC to tvShowDesc)
            }
        }
    }
}