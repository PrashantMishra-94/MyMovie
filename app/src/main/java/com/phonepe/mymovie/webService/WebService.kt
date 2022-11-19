package com.phonepe.mymovie.webService

import com.phonepe.mymovie.webService.models.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("popular")
    suspend fun getPopularMoviesList(@Query("api_key") apiKey: String, @Query("language") language: String = "en-US", @Query("page") page: String = "1"): MovieListResponse?

}