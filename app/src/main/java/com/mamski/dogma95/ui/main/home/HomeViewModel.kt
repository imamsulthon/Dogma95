package com.mamski.dogma95.ui.main.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.mamski.dogma95.Config
import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.data.model.state.MovieDataState
import com.mamski.dogma95.data.repo.BaseRepository
import com.mamski.dogma95.ui.settings.PrefsHelper
import com.mamski.dogma95.ui.viewmodel.BaseViewModel
import kotlin.random.Random

class HomeViewModel @ViewModelInject constructor(
    private val repository: BaseRepository,
    private val prefsHelper: PrefsHelper
): BaseViewModel() {

    var randomCategories: List<String> = getRandoms()

    val dataState1 : MutableLiveData<MovieDataState> by lazy {
        MutableLiveData<MovieDataState>()
    }

    val dataState2 : MutableLiveData<MovieDataState> by lazy {
        MutableLiveData<MovieDataState>()
    }

    val dataState3 : MutableLiveData<MovieDataState> by lazy {
        MutableLiveData<MovieDataState>()
    }

    val data : MutableLiveData<PagedList<Movie>> by lazy {
        MutableLiveData<PagedList<Movie>>()
    }

    fun fetchData() {
        fetchRandomData()
    }

    private fun fetchRandomData() {
        randomCategories.forEachIndexed { index, s ->
            printLog("fetchData2 $index $s")
            when(index) {
                0 -> repository.getRandomCategory(s, dataState1)
                1 -> repository.getRandomCategory(s, dataState2)
                2 -> repository.getRandomCategory(s, dataState3)
            }
        }
    }

    private fun getRandoms(): List<String> {
        val list = mutableListOf(
            Config.Category.Upcoming,
            Config.Category.NowPlaying,
            Config.Category.TopRated,
            Config.Category.Popular,
            Config.Category.Latest
        )
        val setList = prefsHelper.getCategories()
        printLog("getRandoms $setList")
        return list.shuffled().take(3).toList()
    }

    private fun getRandom(): String {
        val list = listOf(
            Config.Category.Upcoming,
            Config.Category.NowPlaying,
            Config.Category.TopRated,
            Config.Category.Popular,
            Config.Category.Latest)
        val selectedString = list.random()
        val listId = intArrayOf(Random.nextInt(0, list.size))
        printLog("category: $selectedString")
        return selectedString
    }

}