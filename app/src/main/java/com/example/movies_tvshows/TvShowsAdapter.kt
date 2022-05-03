package com.example.movies_tvshows
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_tvshows.Models.TVshowModels.TvShowItem
import com.example.movies_tvshows.databinding.LayoutMovieTvShowItemBinding
import com.example.movies_tvshows.Models.TVshowModels.Result

class TvShowsAdapter(val TVshowsList: MutableList<Result>) : RecyclerView.Adapter<TvShowsViewholder>() {
    private lateinit var itemClickListener: (Result, Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewholder {
        val binding =
            LayoutMovieTvShowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewholder(binding)
    }

    fun setOnItemCLickListener(clickListener: (Result, Int) -> Unit) {
        itemClickListener = clickListener
    }

    fun updateList(movies:List<Result>){
        TVshowsList.clear()
        TVshowsList.addAll(movies)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: TvShowsViewholder, position: Int) {
        val movies = TVshowsList[position]
        holder.binding.tvMovieName.text = "title: \n${movies.name}"
        holder.binding.tvRating.text = movies.vote_average.toString()
        holder.binding.tvAverageRating.text = "popularity \n${movies.popularity.toString()}"
        holder.binding.tvReleaseDate.text = "Release Year \n${movies.first_air_date.toString()}"


        holder.binding.tvMovieName.setOnClickListener {
            itemClickListener.invoke(movies,position)
        }
    }

    override fun getItemCount(): Int {
        return TVshowsList.size
    }
}

class TvShowsViewholder(val binding: LayoutMovieTvShowItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

}