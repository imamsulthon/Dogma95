package com.mamski.dogma95.data.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.mamski.dogma95.data.model.state.MovieDataState
import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.data.source.movie.NowPlayingMovieDataSource
import com.mamski.dogma95.data.source.movie.PopularMovieDataSource
import com.mamski.dogma95.data.source.movie.TopRatedMovieDataSource
import com.mamski.dogma95.data.source.movie.UpcomingMovieDataSource
import javax.inject.Inject


class PopularMovieDataFactory @Inject constructor(
    private val dataSource: PopularMovieDataSource
): DataSource.Factory<Int, Movie>() {

    lateinit var liveData: MutableLiveData<MovieDataState>

    override fun create(): DataSource<Int, Movie> {
        return dataSource.also {
            it.liveData = liveData
        }
    }

}
class TopMovieDataFactory @Inject constructor(
    private val dataSource: TopRatedMovieDataSource
) : DataSource.Factory<Int, Movie>() {

    lateinit var liveData: MutableLiveData<MovieDataState>

    override fun create(): DataSource<Int, Movie> {
        return dataSource.also {
            it.liveData = liveData
        }
    }

}

class NowPlayingDataFactory @Inject constructor(
    private val dataSource: NowPlayingMovieDataSource
): DataSource.Factory<Int, Movie>() {

    lateinit var liveData: MutableLiveData<MovieDataState>

    override fun create(): DataSource<Int, Movie> {
        return dataSource.also {
            it.liveData = liveData
        }
    }

}

class UpcomingMovieDataFactory @Inject constructor(
    private val dataSource: UpcomingMovieDataSource
    ): DataSource.Factory<Int, Movie>() {

    lateinit var liveData: MutableLiveData<MovieDataState>

    override fun create(): DataSource<Int, Movie> {
        return dataSource.also {
            it.liveData = liveData
        }
    }

}