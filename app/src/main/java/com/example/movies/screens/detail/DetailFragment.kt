package com.example.movies.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
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
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            Glide.with(this).load(currentMovieUrl).placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_connection_error)
                .into(binding.imageDetail)
        binding.movieTitle.text = currentMovieName
        binding.genre.text = "Жанры: $currentMovieGenres"
        binding.imageDetailFavorite.setOnClickListener {changeRate(it)}
        return view

    }

    private fun changeRate(view:View) {
        if(viewModel.isFavorite.value!!) {
            unmarkAsFavorite()
            view.setBackgroundColor(R.color.white)
        }
        else {
            markAsFavorite()
            view.setBackgroundColor(R.color.purple_200)
        }
    }

    private fun unmarkAsFavorite() {
        viewModel.unmarkAsFavorite()

    }

    private fun markAsFavorite() {
        viewModel.markAsFavorite()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}