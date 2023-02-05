package com.example.movies.screens.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.movies.MoviesApplication
import com.example.movies.R
import com.example.movies.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        val currentMovieUrl = arguments?.getString("posterUrl")
        val currentMovieName = arguments?.getString("nameRu")
        val currentMovieGenres = arguments?.getString("genres")
        val currentMovieCountries = arguments?.getString("countries")
        val currentFilmId = arguments?.getInt("id")
        viewModel = DetailViewModel(activity?.application as MoviesApplication)
        Glide.with(this).load(currentMovieUrl).placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_connection_error)
            .into(binding.imageDetail)
        viewModel.getDescription(currentFilmId)

        binding.movieTitle.text = currentMovieName
        binding.genre.text = "Жанр: $currentMovieGenres"
        binding.countries.text="Страны: $currentMovieCountries"
        //binding.imageDetailFavorite.setOnClickListener { changeRate(it) }
        viewModel.description.observe(viewLifecycleOwner) {
            binding.filmDescription.text = it
        }
        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        (activity as AppCompatActivity?)!!.window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.BLACK
        }
    }
}