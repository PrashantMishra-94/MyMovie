package com.phonepe.mymovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.phonepe.mymovie.databinding.ActivityMainBinding
import com.phonepe.mymovie.repo.Repository
import com.phonepe.mymovie.viewModels.MovieListViewModel
import com.phonepe.mymovie.viewModels.ViewModelFactory
import com.phonepe.mymovie.webService.RetrofitInstance
import com.phonepe.mymovie.webService.models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieListViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(Repository(this.applicationContext))).get()
        viewModel.getMovieList()
        viewModel.movieList.observe(this) {
            binding.recyclerView.adapter = MovieAdapter(it, object : MovieAdapter.MovieSelectedListener {
                override fun movieSelected(movie: Movie) {

                }
            })
        }
    }
}