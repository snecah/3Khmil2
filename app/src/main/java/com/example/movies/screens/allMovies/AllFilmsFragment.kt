package com.example.movies.screens.allMovies

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.movies.MAIN
import com.example.movies.MoviesApplication
import com.example.movies.R
import com.example.movies.databinding.FragmentAllMoviesBinding

class AllFilmsFragment : Fragment() {

    private var _binding: FragmentAllMoviesBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: AllFilmsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllMoviesBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        val viewModel = AllFilmsViewModel(activity?.application as MoviesApplication)
        val adapter = AllFilmsAdapter()
        binding.movieList.adapter = adapter
        viewModel.getMovies()
        viewModel.myMovies.observe(viewLifecycleOwner) { list ->
            adapter.data = list
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}