package com.mamski.dogma95.ui.main.notifications

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mamski.dogma95.data.model.state.MovieDataState
import com.mamski.dogma95.data.repo.DataRepository

class NotificationsViewModel @ViewModelInject constructor(
    private val repository: DataRepository): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }

    val state: MutableLiveData<MovieDataState> by lazy {
        MutableLiveData<MovieDataState>()
    }

    val text: LiveData<String> = _text

    fun fetchList() {
        repository.getNowPlaying(state)
    }
}