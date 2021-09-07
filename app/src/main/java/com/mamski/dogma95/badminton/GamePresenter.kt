package com.mamski.dogma95.badminton

interface GamePresenter {

    fun sideOneServe(): Boolean
    fun sideTwoServe(): Boolean

    fun addPoint(score: Score)
    fun reducePoint(score: Score)

    fun justAddPoint(score: Score)
    fun justDismissPoint(score: Score)

}