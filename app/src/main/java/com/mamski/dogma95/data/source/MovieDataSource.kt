package com.mamski.dogma95.data.source

import com.mamski.dogma95.Config
import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.data.model.state.MovieDataState
import com.mamski.dogma95.data.network.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDataSource @Inject constructor(
    private val apiService: ApiService
    ): BaseDataSource<Movie, MovieDataState>() {

    private val key: String = Config.Category.Popular

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        printLog("$key loadInitial")
        apiService.fetchMovieList(key, 1)
            .map<MovieDataState> {
                callback.onResult(it.result!!.toMutableList(), 1, 2)
                MovieDataState.Result(it)
            }
            .onErrorReturn(MovieDataState::Error)
            .toFlowable()
            .startWith(MovieDataState.Loading)
            .subscribe {
                liveData.postValue(it)
            }
            .let{ return@let disposable::add }
    }


    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        printLog("$key loadBefore")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        printLog("$key loadAfter paramsKey ${params.key} ")
        apiService.fetchMovieList(key, 1)
            .map<MovieDataState> {
                callback.onResult(it.result!!.toMutableList(), params.key + 1)
                MovieDataState.Result(it)
            }
            .onErrorReturn(MovieDataState::Error)
            .toFlowable()
            .startWith(MovieDataState.Loading)
            .subscribe(liveData::postValue)
            .let{ return@let disposable::add }
    }
}
