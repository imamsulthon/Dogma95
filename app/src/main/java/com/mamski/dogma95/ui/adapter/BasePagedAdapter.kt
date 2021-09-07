package com.mamski.dogma95.ui.adapter

import androidx.paging.PagedListAdapter
import com.mamski.dogma95.data.model.movie.Movie

abstract class BasePagedAdapter<VH: BaseViewHolder<Movie>>(): PagedListAdapter<Movie, VH>(DiffCallback) {

    open fun printLog(msg: String) {
        println("${javaClass.simpleName}: $msg")
    }

}