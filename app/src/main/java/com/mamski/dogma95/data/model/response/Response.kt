package com.mamski.dogma95.data.model.response

import com.google.gson.annotations.SerializedName
import com.mamski.dogma95.data.model.movie.Movie

// region Base
data class MainResponse<T>(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val result: List<T>,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    var category: String
)
// endregion

// region Movie
data class MovieResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val result: List<Movie>,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)
// endregion