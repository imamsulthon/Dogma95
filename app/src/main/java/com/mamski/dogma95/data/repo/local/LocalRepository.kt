package com.mamski.dogma95.data.repo.local

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.mamski.dogma95.data.database.AppRoomDatabase
import com.mamski.dogma95.data.database.entity.MovieEntity
import com.mamski.dogma95.data.model.state.MovieDataState
import com.mamski.dogma95.data.repo.BaseRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val database: AppRoomDatabase,
    private val config: PagedList.Config
): BaseRepository {

    private var disposable: CompositeDisposable = CompositeDisposable()

    override fun getNowPlaying(callBack: MutableLiveData<MovieDataState>) {
        throw UnsupportedOperationException()
    }

    override fun getUpcoming(callBack: MutableLiveData<MovieDataState>) {
        throw UnsupportedOperationException()
    }

    override fun getPopular(callBack: MutableLiveData<MovieDataState>) {
        throw UnsupportedOperationException()
    }

    override fun getTopRated(callBack: MutableLiveData<MovieDataState>) {
        throw UnsupportedOperationException()
    }

    override fun getLatest(callBack: MutableLiveData<MovieDataState>) {
        throw UnsupportedOperationException()
    }

    override fun addDataMovie(data: MovieEntity) {
        database.movie().add(data)
    }

    override fun checkDataMovie(data: MovieEntity): List<MovieEntity> {
        return database.movie().getDataById(data.id)
    }

    override fun deleteDataMovie(data: MovieEntity) {
        database.movie().delete(data)
    }

    override fun getDisposable(): CompositeDisposable {
        return disposable
    }

    override fun getDataBase(): AppRoomDatabase = database

    override fun getRandomCategory(category: String, callBack: MutableLiveData<MovieDataState>) {
    }

}