package com.mamski.dogma95.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.databinding.AdapterMovieBinding

class MovieAdapter(private val showDetail: (Movie) -> Unit): BasePagedAdapter<ExampleViewHolder>() {

    private var data = ArrayList<Movie>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(movieList: List<Movie>?) {
        if (movieList.isNullOrEmpty()) return
        printLog("setData")
        data.clear()
        data.addAll(movieList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder = ExampleViewHolder(
        AdapterMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val item = getItem(position)
        printLog("onBindViewHolder ${item?.title}")
        holder.bind(item!!)
    }

}