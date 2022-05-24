package com.example.movies_tvshows.Fragments.login

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.movies_tvshows.API.GetSessionIDResponse
import com.example.movies_tvshows.Fragments.MovieViews.MoviesListFragment
import com.example.movies_tvshows.Fragments.TVshowViews.TvShowsListFragment
import com.example.movies_tvshows.Models.LoginScreenData.LoginRequestModel
import com.example.movies_tvshows.MoviesAdapter
import com.example.movies_tvshows.R
import com.example.movies_tvshows.databinding.LoginLayoutBinding
import kotlinx.coroutines.handleCoroutineException
import kotlinx.parcelize.Parcelize
import okhttp3.Response
import retrofit2.HttpException


class LoginFragment:Fragment() {

    private var _binding: LoginLayoutBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<LoginVeiwModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginLayoutBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTokenLiveData().observe(viewLifecycleOwner,){
            viewModel.getSessionId(it)
        }

        binding.btnLogin.setOnClickListener {
            val useri = binding.etUsername.text.toString()
            val paroli = binding.etPassword.text.toString()

            viewModel.logIn(useri,paroli)

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flContent, MoviesListFragment())
                addToBackStack(MoviesListFragment::javaClass.name)
                commit()
            }
        }

        binding.btnSkipButton.setOnClickListener {
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

