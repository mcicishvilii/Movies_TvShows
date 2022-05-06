package com.example.movies_tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies_tvshows.Models.MovieModels.Result1
import com.example.movies_tvshows.databinding.LayoutMovieItemBinding


class MoviesAdapter(val movieList: MutableList<Result1>) : RecyclerView.Adapter<MoviesViewHolder>() {
    private lateinit var itemClickListener: (Result1, Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding =
            LayoutMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    fun setOnItemCLickListener(clickListener: (Result1, Int) -> Unit) {
        itemClickListener = clickListener
    }



    fun updateList(movies:List<Result1>){
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        val movie = movieList[position]
        holder.binding.tvMovieName.text = "title: \n${movie.original_title}"
        holder.binding.tvRating.text = movie.vote_average.toString()
        holder.binding.ivImagePoster.setImageURI("https://image.tmdb.org/t/p/w500${movie.poster_path}")
        holder.binding.tvReleaseDate.text = "release date: \n${movie.release_date.toString()}"
        holder.binding.tvAverageRating.text = "total votes: \n${movie.vote_count.toString()}"

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