package com.example.runprof_task.homeScreen.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.runprof_task.R
import com.example.runprof_task.common.util.Constant
import com.example.runprof_task.common.util.getDecimalRate
import com.example.runprof_task.databinding.MovieItemBinding
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

class HomeAdapter @Inject constructor(var onClick: OnClickToShowDetails) :
    PagingDataAdapter<Movie, HomeAdapter.HomeViewHolder>(differCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        holder.setIsRecyclable(false)

    }

    inner class HomeViewHolder(private var binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieItem: Movie) {
            binding.apply {
                Glide.with(binding.root).load(Constant.IMAGES_URL + movieItem.poster_path)
                    .placeholder(R.drawable.movie_placholder)
                    .into(binding.moviePoster)
                binding.movieName.text = movieItem.title
                binding.movieDate.text = movieItem.release_date
                binding.movieRate.text = getDecimalRate(movieItem.vote_average)
                binding.root.setOnClickListener {
                    onClick.showDetails(movieItem.id)
                }
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