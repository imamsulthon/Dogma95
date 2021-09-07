package com.mamski.dogma95.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(view: View): RecyclerView.ViewHolder(view) {

    abstract fun bind(item: T)

    open fun printLog(msg: String) {
        println("${javaClass.simpleName}: $msg")
    }

}