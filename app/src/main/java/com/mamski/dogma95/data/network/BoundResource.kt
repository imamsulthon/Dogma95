package com.mamski.dogma95.data.network

import android.database.Observable
import androidx.lifecycle.LiveData

abstract class BoundResource<RequestType, ResultType> {

    protected abstract fun saveCallResult(item: RequestType)

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun loadFromCache()

    protected abstract fun loadFromDb()

    protected abstract fun createCall()

    protected open fun onFetchFailed() {}

    fun asLiveData(): LiveData<ResultType> = TODO()

    fun asObservable(): Observable<ResultType> = TODO()
}