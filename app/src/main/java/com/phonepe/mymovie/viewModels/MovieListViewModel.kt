package com.phonepe.mymovie.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phonepe.mymovie.repo.Repository
import com.phonepe.mymovie.webService.models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel(private val repository: Repository): ViewModel() {

    val movieList: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()


    fun getMovieList() {
        viewModelScope.launch(Dispatchers.Default) {
            repository.getMoviesList()?.let {
                movieList.postValue(it.results!!)
            }
        }
    }
}