package com.phonepe.mymovie.webService.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class MovieListResponse(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<Movie>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)