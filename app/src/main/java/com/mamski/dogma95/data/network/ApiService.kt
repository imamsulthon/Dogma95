package com.mamski.dogma95.data.network

import com.mamski.dogma95.Config
import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.data.model.person.Credit
import com.mamski.dogma95.data.model.response.MainResponse
import com.mamski.dogma95.data.model.response.MovieResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/{list}")
    fun fetchMovieList(
        @Path("list") list: String,
        @Query("page") page: Int? = null
    ): Single<MainResponse<Movie>>

    @GET("movie/${Config.Category.Latest}")
    fun fetchLatest(): Single<Movie>

    @GET("movie/${Config.Category.Popular}")
    fun fetchPopular(): Single<MainResponse<Movie>>

    @GET("movie/${Config.Category.NowPlaying}")
    fun fetchNowPlaying(
        @Query("page") page: Int? = null
    ): Single<MainResponse<Movie>>

    @GET("movie/${Config.Category.TopRated}")
    fun fetchTopRated(
        @Query("page") page: Int? = null
    ): Single<MainResponse<Movie>>

    @GET("movie/{movieId}")
    fun fetchMovieDetail(@Path("movieId") movieId: String)
    : Single<Movie>

    fun getDetails(): Observable<Movie>

    fun getCrews(): Observable<Credit>

}