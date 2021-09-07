package com.mamski.dogma95.data.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable

abstract class BaseDataSource<I, S>: PageKeyedDataSource<Int, I>() {

    lateinit var liveData: MutableLiveData<S>

    protected val disposable by lazy {
        CompositeDisposable()
    }

    fun printLog(msg: Any?) {
        println(msg)
    }
}