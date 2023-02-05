package com.example.movies.screens.allMovies

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movies.MAIN
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

        viewModel = ViewModelProvider(this).get(AllFilmsViewModel::class.java)
        val adapter = AllFilmsAdapter()
        binding.movieList.adapter = adapter
        viewModel.getMovies()
        viewModel.myMovies.observe(viewLifecycleOwner) { list ->
            adapter.data = list.body()!!.films
        }
        setHasOptionsMenu(true)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.all_movies_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.item_favorite -> {
                MAIN.navController.navigate(R.id.action_allMoviesFragment_to_favoriteFragment)
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}