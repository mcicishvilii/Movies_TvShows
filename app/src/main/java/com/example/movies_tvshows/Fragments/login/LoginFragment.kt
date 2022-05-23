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
import com.example.movies_tvshows.Fragments.MovieViews.MoviesListFragment
import com.example.movies_tvshows.Models.LoginScreenData.LoginRequestModel
import com.example.movies_tvshows.MoviesAdapter
import com.example.movies_tvshows.R
import com.example.movies_tvshows.databinding.LoginLayoutBinding
import kotlinx.parcelize.Parcelize




class LoginFragment:Fragment() {

    private var _binding: LoginLayoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: LoginVeiwModel


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


        val useri = "hekkah"
        val paroli = "Kubriki19"
        val request_tokeni = viewModel.getToken().toString()

        val loginDetails = LoginRequestModel(useri,paroli, request_tokeni)

        viewModel.pushLogin(loginDetails)
        viewModel.myResponse.observe(viewLifecycleOwner, { response ->
            Toast.makeText(requireContext(),request_tokeni,Toast.LENGTH_SHORT).show()
        })



        binding.btnLogin.setOnClickListener {

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

