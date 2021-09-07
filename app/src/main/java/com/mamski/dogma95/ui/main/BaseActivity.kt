package com.mamski.dogma95.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateLayout(layoutInflater)
        setContentView(binding.root)
        onCreateHandle()
    }

    abstract fun inflateLayout(layoutInflater: LayoutInflater) : VB

    abstract fun onCreateHandle()

    open fun printLog(msg: Any) {
        println("${javaClass.simpleName}: $msg")
    }

}