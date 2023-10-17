package com.example.runprof_task.homeScreen.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.runprof_task.R
import com.example.runprof_task.databinding.MovieItemBinding
import com.example.runprof_task.homeScreen.model.Movie

class HomeAdapter(var moviesList : List<Movie>)  : RecyclerView.Adapter <HomeAdapter.HomeViewHolder>(){
    val imgUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = MovieItemBinding.inflate( LayoutInflater.from(parent.context),parent,false)
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun updateFavList(favListUpdated : List<Movie>){
        moviesList = favListUpdated
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val movieItem = moviesList[position]
        Glide.with(holder.binding.root).load(imgUrl+ movieItem.poster_path).into(holder.binding.moviePoster)
        holder.binding.movieName.text = movieItem.title
        holder.binding.movieDate.text = movieItem.release_date
        holder.binding.movieRate.text = movieItem.vote_average.toString()
    }






    inner class HomeViewHolder(var binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root)
}