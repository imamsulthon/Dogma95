package com.mamski.dogma95

import com.mamski.dogma95.badminton.Score
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CoretCoret {


    fun donennen() {
        val scorelist = listOf<Score>()
        val lisst = listOf<Score>()
        val join = listOf(scorelist, lisst)
        val update = join.flatMap {
            it
        }.map {
            it.isServeTurn =false
        }


        Observable.fromArray(1, 2, 3, 5)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it * it
            }
            .doOnNext {
            }
            .doOnComplete {
            }.doOnSubscribe {

            }
            .subscribe(
                { value -> println("Received: $value") }, // onNext
                { error -> println("Error: $error") },    // onError
                { println("Completed!") }
            )
            .let {

            }

        getObservable().subscribe(getObserver())
    }


    fun getSingle(): Single<String> {
        return Single.just("it")
    }

    fun getObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: String) {

            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {

            }

        }
    }

    fun getObservable(): Observable<String> {
        return Observable.fromArray("1", "2", "3", "4", "5")
    }
}