package com.phonepe.mymovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.phonepe.mymovie.databinding.MovieListBinding
import com.phonepe.mymovie.webService.models.Movie

class MovieAdapter(private val movies: List<Movie>, private val listener: MovieSelectedListener):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: MovieListBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnAddPlayList.setOnClickListener {
                listener.movieSelected(movies[bindingAdapterPosition])
            }
        }
    }

    interface MovieSelectedListener {
        fun movieSelected(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.apply {
            Glide.with(movieImageView.context).load(BASE_IMAGE_URL + movie.posterPath).into(movieImageView)
            txtTitle.text = movie.title
            txtRating.text = txtRating.context.getString(R.string.rating, movie.voteAverage?.toFloat())
        }
    }

    override fun getItemCount(): Int = movies.size

    companion object {
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    }
}