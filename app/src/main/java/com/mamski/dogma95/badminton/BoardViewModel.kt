package com.mamski.dogma95.badminton

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BoardViewModel: ViewModel() {

    lateinit var isSideOneTurn: MutableLiveData<Boolean>
    lateinit var isSideTwoTurn: MutableLiveData<Boolean>
    lateinit var sideOneScore: MutableLiveData<Int>
    lateinit var sideTwoScore: MutableLiveData<Int>
    var maxScore = 21

    lateinit var score1: Score
    lateinit var score2: Score

    fun addPointSideOne() {
        if (isGameOver(score1, maxScore)) return
        score1.also {
            it.point++
            it.isServeTurn = true
        }
        sideOneScore.postValue(score1.point)
        isSideOneTurn.postValue(score1.isServeTurn)
        isSideTwoTurn.postValue(score2.isServeTurn)
        if (isGameOver(score1, maxScore)) {
            return
        }
        addMaxScore(score1, score2)
    }

    fun addPointSideTwo() {
        score2.also {
            it.point++
            it.isServeTurn = true
        }
        sideTwoScore.postValue(score2.point)
        isSideTwoTurn.postValue(score2.isServeTurn)
        isSideOneTurn.postValue(score1.isServeTurn)
        if (isGameOver(score1, maxScore)) {
            return
        }
        addMaxScore(score1, score2)
    }

    fun addPoint(score: Score): Score {
        return score.also {
            it.point++
        }
    }

    fun reducePoint(score: Score): Score {
        return score.also {
            it.point--
        }
    }

    private fun addMaxScore(score1: Score, score2: Score) {
        if (score1.point + 2 == maxScore && score2.point + 2 == maxScore) maxScore++
    }

    fun reduceMaxScore(score1: Score, score2: Score) {
        if (maxScore - 2 == score1.point && maxScore - 2 == score2.point) {
            maxScore--
        }
    }

    fun isDeuce(score1: Score, score2: Score, max: Int): Boolean {
        if (score1.point < 20 && score2.point < 20) return false
        return max - 2 == score1.point || max - 2 == score2.point
    }

    private fun isGameOver(score: Score, max: Int): Boolean {
        return score.point == max
    }

    fun isGamePoint(score: Score, max: Int): Boolean {
        return score.isServeTurn && (max - score.point) == 1
    }

    fun saveGame() {
//        repo.saveGame(score1, score2)
    }

}