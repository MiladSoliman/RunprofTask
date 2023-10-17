package com.example.runprof_task.homeScreen.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.runprof_task.R
import com.example.runprof_task.databinding.MovieItemBinding
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

class HomeAdapter @Inject constructor(var moviesList: List<Movie>)  :  PagingDataAdapter<Movie, HomeAdapter.HomeViewHolder>(differCallback) {
    val imgUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

   /*  override fun getItemCount(): Int {
         if (moviesList.isNotEmpty())
             return moviesList.size
     }*/

    fun updateFavList(favListUpdated : List<Movie>){
        getItem(favListUpdated.size)
        moviesList = favListUpdated
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        if (moviesList.isNotEmpty() ) {
            val movieItem = moviesList[position]
            Glide.with(holder.binding.root).load(imgUrl + movieItem.poster_path)
                .into(holder.binding.moviePoster)
            holder.binding.movieName.text = movieItem.title
            holder.binding.movieDate.text = movieItem.release_date
            holder.binding.movieRate.text = movieItem.vote_average.toString()
        } else {
            holder.bind(getItem(position)!!)
            holder.setIsRecyclable(false)
        }
    }


    inner class HomeViewHolder(var binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieItem: Movie) {
            binding.apply {
                Glide.with(binding.root).load(imgUrl + movieItem.poster_path).placeholder(R.drawable.movie_placholder)
                    .into(binding.moviePoster)
                binding.movieName.text = movieItem.title
                binding.movieDate.text = movieItem.release_date
                binding.movieRate.text = movieItem.vote_average.toString()
            }
        }
    }


    companion object {
        val differCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == oldItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}