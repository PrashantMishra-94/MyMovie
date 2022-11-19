package com.phonepe.mymovie.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.phonepe.mymovie.repo.Repository
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
            return MovieListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}