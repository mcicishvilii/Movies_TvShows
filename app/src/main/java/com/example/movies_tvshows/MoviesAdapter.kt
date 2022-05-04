package com.example.movies_tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_tvshows.Models.MovieModels.MovieItem
import com.example.movies_tvshows.databinding.LayoutMovieItemBinding


class MoviesAdapter(val movieList: MutableList<MovieItem>) : RecyclerView.Adapter<MoviesViewHolder>() {
    private lateinit var itemClickListener: (MovieItem, Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding =
            LayoutMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    fun setOnItemCLickListener(clickListener: (MovieItem, Int) -> Unit) {
        itemClickListener = clickListener
    }

    fun updateList(movies:List<MovieItem>){
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.tvMovieName.text = "title: \n${movie.originalTitle}"
        holder.binding.tvRating.text = movie.voteAverage.toString()
        holder.binding.tvReleaseDate.text = "release date: \n${movie.releaseDate.toString()}"
        holder.binding.tvAverageRating.text = "total votes: \n${movie.voteCount.toString()}"

        holder.binding.tvMovieName.setOnClickListener {
            itemClickListener.invoke(movie,position)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MoviesViewHolder(val binding: LayoutMovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

}