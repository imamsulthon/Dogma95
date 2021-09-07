package com.mamski.dogma95.data.network

import com.mamski.dogma95.data.model.movie.Movie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiService: ApiService {

    @GET("movie/{movie_id}")
    fun getDetails(
        @Path("movie_id") list: String
    ): Single<Movie>

    @GET("movie/{movie_id}/credits")
    fun getCredits(): Single<Movie>

}