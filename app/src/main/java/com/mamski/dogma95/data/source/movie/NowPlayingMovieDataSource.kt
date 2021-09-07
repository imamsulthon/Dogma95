package com.mamski.dogma95.data.source.movie

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.mamski.dogma95.Config
import com.mamski.dogma95.data.model.state.MovieDataState
import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.data.network.ApiService
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NowPlayingMovieDataSource @Inject constructor(
    private val apiService: ApiService
): PageKeyedDataSource<Int, Movie>() {

    lateinit var liveData: MutableLiveData<MovieDataState>
    private val disposable by lazy { CompositeDisposable() }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        apiService.fetchMovieList(Config.Category.TopRated, 1)
            .map<MovieDataState> {
                callback.onResult(it.result!!.toMutableList(), 1, 2)
                MovieDataState.Result(it)
            }
            .onErrorReturn {
                MovieDataState.Error(it)
            }
            .toFlowable()
            .startWith(MovieDataState.Loading)
            .subscribe(liveData::postValue).let {
                return@let disposable::add
            }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        apiService.fetchMovieList(Config.Category.TopRated, 1)
            .map<MovieDataState> {
                callback.onResult(it.result!!.toMutableList(), params.key + 1)
                MovieDataState.Result(it)
            }
            .toFlowable()
            .startWith(MovieDataState.Loading)
            .subscribe(liveData::postValue).let {
                return@let disposable::add
            }
    }

}