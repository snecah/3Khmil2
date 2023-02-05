package com.example.movies.screens.allMovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.MAIN
import com.example.movies.R
import com.example.movies.data.Film
import kotlinx.android.synthetic.main.movie_item.view.*


class AllFilmsAdapter:RecyclerView.Adapter< AllFilmsAdapter.ViewHolder>() {
    var data =  listOf<Film>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Film) {
            itemView.movie_item_title.text = item.nameRu
            itemView.movie_item_date.text = item.year
            Glide.with(itemView.context).load(item.posterUrlPreview).
            placeholder(R.drawable.loading_animation).error(R.drawable.ic_connection_error).into(itemView.movie_item_poster)
            itemView.setOnClickListener {
                onClick(item)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.movie_item, parent, false)
                return ViewHolder(view)
            }

            fun onClick(movie: Film) {
                val bundle = Bundle()
                bundle.putString("posterUrl", movie.posterUrl)
                bundle.putString("nameRu", movie.nameRu)
                bundle.putString("genres", movie.genres.joinToString { genre -> genre.genre })
                MAIN.navController.navigate(R.id.action_allMoviesFragment_to_detailFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface Listener{
        fun onClick(movie: Film)
    }

}