package com.mamski.dogma95.data.repo

import androidx.lifecycle.MutableLiveData
import com.mamski.dogma95.data.database.AppRoomDatabase
import com.mamski.dogma95.data.database.entity.MovieEntity
import com.mamski.dogma95.data.model.state.MovieDataState
import io.reactivex.disposables.CompositeDisposable


interface AppRepository{

}

interface BaseRepository {

    fun getDisposable() : CompositeDisposable
    fun getDataBase(): AppRoomDatabase

    fun getRandomCategory(category: String, callBack: MutableLiveData<MovieDataState>)
    fun getNowPlaying(callBack: MutableLiveData<MovieDataState>)
    fun getUpcoming(callBack: MutableLiveData<MovieDataState>)
    fun getPopular(callBack: MutableLiveData<MovieDataState>)
    fun getTopRated(callBack: MutableLiveData<MovieDataState>)
    fun getLatest(callBack: MutableLiveData<MovieDataState>)

    fun addDataMovie(data : MovieEntity)
    fun checkDataMovie(data: MovieEntity) : List<MovieEntity>
    fun deleteDataMovie(data: MovieEntity)

}

interface MovieRepository: BaseRepository {

}

interface TvRepository: BaseRepository {
    fun getAiringToday()
}