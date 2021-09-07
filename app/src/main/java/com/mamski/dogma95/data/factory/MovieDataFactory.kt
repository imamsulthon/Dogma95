package com.mamski.dogma95.data.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.data.model.state.MovieDataState
import com.mamski.dogma95.data.source.MovieDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDataFactory @Inject constructor(
    private val dataSource: MovieDataSource
): DataSource.Factory<Int, Movie>() {

    lateinit var livedata: MutableLiveData<MovieDataState>

    override fun create(): DataSource<Int, Movie> {
        return dataSource.also {
            it.liveData = livedata
        }
    }

}
