package com.mamski.dogma95.ui.viewmodel

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

    open fun printLog(msg: Any) {
        println("${javaClass.simpleName} msg")
    }

}