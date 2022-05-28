package com.example.movies_tvshows.Fragments.watchlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_tvshows.Models.MovieModels.Result1
import com.example.movies_tvshows.databinding.LayoutMovieItemBinding
import com.example.movies_tvshows.databinding.WatchlistItemLayoutBinding
import com.example.movies_tvshows.databinding.WatchlistLayoutBinding

class WatchlistAdapter(val movieList: MutableList<Result1>) : RecyclerView.Adapter<WatchlistViewHolder>() {
    private lateinit var itemClickListener: (Result1, Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchlistViewHolder {
        val binding =
            WatchlistItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WatchlistViewHolder(binding)
    }

    fun updateList(movies:List<Result1>){
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }

    fun setOnItemCLickListener(clickListener: (Result1, Int) -> Unit) {
        itemClickListener = clickListener
    }

    override fun onBindViewHolder(holder: WatchlistViewHolder, position: Int) {

        val movie = movieList[position]
        holder.binding.tvMovieName.text = "title: \n${movie.original_title}"
//        holder.binding.tvMovieName.setOnClickListener {
//            itemClickListener.invoke(movie,position)
//        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}



class WatchlistViewHolder(val binding: WatchlistItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

}