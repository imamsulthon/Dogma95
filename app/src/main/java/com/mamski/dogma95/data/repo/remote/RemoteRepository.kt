package com.mamski.dogma95.data.repo.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.mamski.dogma95.Config
import com.mamski.dogma95.data.database.AppRoomDatabase
import com.mamski.dogma95.data.database.entity.MovieEntity
import com.mamski.dogma95.data.factory.MovieDataFactory
import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.data.model.person.Credit
import com.mamski.dogma95.data.model.response.MainResponse
import com.mamski.dogma95.data.model.response.MovieResponse
import com.mamski.dogma95.data.model.state.MovieDataState
import com.mamski.dogma95.data.network.ApiService
import com.mamski.dogma95.data.network.BoundResource
import com.mamski.dogma95.data.repo.BaseRepository
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val apiService: ApiService,
    private val config: PagedList.Config,
    private val factory: MovieDataFactory
) : BaseRepository {

    private var disposable: CompositeDisposable = CompositeDisposable()

    override fun getRandomCategory(category: String, callBack: MutableLiveData<MovieDataState>) {
        apiService.fetchMovieList(category, 1)
            .subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
            .map<MovieDataState>{
                it.category = category
                MovieDataState.Result(it)
            }
            .onErrorReturn(MovieDataState::Error)
            .toFlowable()
            .startWith(MovieDataState.Loading)
            .subscribe(callBack::postValue)
            .let { return@let disposable::add}
    }

    override fun getNowPlaying(callBack: MutableLiveData<MovieDataState>) {
        apiService.fetchMovieList(Config.Category.NowPlaying, 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map<MovieDataState>{
                it.category = Config.Category.NowPlaying
                MovieDataState.Result(it)
            }
            .onErrorReturn(MovieDataState::Error)
            .toFlowable()
            .startWith(MovieDataState.Loading)
            .subscribe(callBack::postValue)
            .let { return@let disposable::add}
    }

    override fun getUpcoming(callBack: MutableLiveData<MovieDataState>) {
        apiService.fetchMovieList(Config.Category.Upcoming, 1)
            .subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
            .map<MovieDataState>{
                it.category = Config.Category.Upcoming
                MovieDataState.Result(it)
            }
            .onErrorReturn(MovieDataState::Error)
            .toFlowable()
            .startWith(MovieDataState.Loading)
            .subscribe(callBack::postValue)
            .let { return@let disposable::add}
    }

    override fun getPopular(callBack: MutableLiveData<MovieDataState>) {
        apiService.fetchPopular()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map<MovieDataState> {
                it.category = Config.Category.Popular
                MovieDataState.Result(it)
            }
            .onErrorReturn(MovieDataState::Error)
            .toFlowable()
            .startWith (MovieDataState.Loading)
            .subscribe(callBack::postValue)
            .let {
                return@let disposable::add
            }
    }

    override fun getTopRated(callBack: MutableLiveData<MovieDataState>) {
        apiService.fetchMovieList(Config.Category.TopRated)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map<MovieDataState> {
                it.category = Config.Category.TopRated
                MovieDataState.Result(it)
            }
            .onErrorReturn(MovieDataState::Error)
            .toFlowable()
            .startWith(MovieDataState.Loading)
            .subscribe(callBack::postValue)
            .let { return@let disposable::add}
    }

    override fun getLatest(callBack: MutableLiveData<MovieDataState>) {
        apiService.fetchLatest()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map<MainResponse<Movie>>{
                MainResponse(1, listOf(it), 1, 1, Config.Category.Latest)
            }
            .map<MovieDataState>(MovieDataState::Result)
            .onErrorReturn(MovieDataState::Error)
            .toFlowable()
            .startWith { MovieDataState.Loading }
            .subscribe(callBack::postValue)
            .let { return@let disposable::add }
    }

    private fun execute(id: String): Single<MainResponse<Movie>> {
        return apiService.fetchMovieList(id, 1)
    }

    fun getRandomList(id: String, callBack: MutableLiveData<MovieDataState>) {
        apiService.fetchMovieList(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                printLog("onSuccess ${it.page} ${it.totalPages} ${it.totalResults}")
            }
            .doOnError {
                printLog("onErrorReturn")
            }
            .let { return@let disposable::add }
    }

    fun getDetails(id: String, callBack: MutableLiveData<Movie>) {
        apiService.fetchMovieDetail(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callBack::postValue)
            .let { return@let disposable::add }
    }

    fun zipFunction(id: String, callBack: MutableLiveData<Movie>) {
        Observable.zip(
            apiService.getDetails().subscribeOn(Schedulers.io()),
            apiService.getCrews().subscribeOn(Schedulers.io()),
            BiFunction<Movie, Credit, Movie> {movie, crews ->
                movie
            })
            .subscribe(callBack::postValue)
            .let { return@let disposable::add }
    }

    fun createRepo(): LiveData<MovieResponse> {
        return object : BoundResource<List<Movie>, MovieResponse>() {
            override fun saveCallResult(item: List<Movie>) {
            }

            override fun shouldFetch(data: MovieResponse?): Boolean {
                return false
            }

            override fun loadFromCache() {
            }

            override fun loadFromDb() {
            }

            override fun createCall() {
            }

        }.asLiveData()
    }

    // region save to local favorite
    override fun addDataMovie(data: MovieEntity) {
        TODO("Not yet implemented")
    }

    override fun checkDataMovie(data: MovieEntity): List<MovieEntity> {
        TODO("Not yet implemented")
    }

    override fun deleteDataMovie(data: MovieEntity) {
        TODO("Not yet implemented")
    }

    override fun getDataBase(): AppRoomDatabase {
        TODO("Not yet implemented")
    }
    // endregion

    override fun getDisposable(): CompositeDisposable = disposable

    private fun printLog(msg: Any) {
        println("Repos $msg")
    }

}