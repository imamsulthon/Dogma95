package com.mamski.dogma95.data.repo

import androidx.lifecycle.MutableLiveData
import com.mamski.dogma95.Config
import com.mamski.dogma95.data.database.AppRoomDatabase
import com.mamski.dogma95.data.database.entity.MovieEntity
import com.mamski.dogma95.data.model.state.MovieDataState
import com.mamski.dogma95.data.repo.local.LocalRepository
import com.mamski.dogma95.data.repo.remote.RemoteRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
): BaseRepository {

    override fun getNowPlaying(callBack: MutableLiveData<MovieDataState>) {
        remoteRepository.getNowPlaying(callBack)
    }

    override fun getUpcoming(callBack: MutableLiveData<MovieDataState>) {
        remoteRepository.getUpcoming(callBack)
    }

    override fun getPopular(callBack: MutableLiveData<MovieDataState>) {
        remoteRepository.getPopular(callBack)
    }

    override fun getTopRated(callBack: MutableLiveData<MovieDataState>) {
        remoteRepository.getTopRated(callBack)
    }

    override fun getLatest(callBack: MutableLiveData<MovieDataState>) {
        remoteRepository.getLatest(callBack)
    }

    override fun addDataMovie(data: MovieEntity) {
        localRepository.addDataMovie(data)
    }

    override fun checkDataMovie(data: MovieEntity): List<MovieEntity> {
        return localRepository.checkDataMovie(data)
    }

    override fun deleteDataMovie(data: MovieEntity) {
        localRepository.deleteDataMovie(data)
    }

    override fun getDisposable(): CompositeDisposable {
        return remoteRepository.getDisposable()
    }

    override fun getDataBase(): AppRoomDatabase {
        return localRepository.getDataBase()
    }

    override fun getRandomCategory(category: String, callBack: MutableLiveData<MovieDataState>) {
        when (category) {
            Config.Category.Upcoming -> remoteRepository.getRandomCategory(category, callBack)
            Config.Category.Popular -> remoteRepository.getRandomCategory(category, callBack)
            Config.Category.TopRated -> remoteRepository.getRandomCategory(category, callBack)
            Config.Category.NowPlaying -> remoteRepository.getRandomCategory(category, callBack)
//            Config.Category.Upcoming -> remoteRepository.getUpcoming(callBack)
//            Config.Category.Popular -> remoteRepository.getPopular(callBack)
//            Config.Category.TopRated -> remoteRepository.getTopRated(callBack)
//            Config.Category.NowPlaying -> remoteRepository.getNowPlaying(callBack)
            Config.Category.Latest -> remoteRepository.getLatest(callBack)
//            else -> remoteRepository.getRandomCategory(category, callBack)
        }
    }

}