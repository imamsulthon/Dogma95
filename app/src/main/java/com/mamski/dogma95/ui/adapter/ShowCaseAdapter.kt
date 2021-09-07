package com.mamski.dogma95.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.databinding.AdapterShowcaseBinding

class ShowCaseAdapter(private val showDetail: (Movie) -> Unit): RecyclerView.Adapter<ExampleViewHolder>() {

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
        AdapterShowcaseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val item = data[position]
        printLog("onBindViewHolder ${item.title}")
        holder.bind(item)
        holder.itemView.setOnClickListener { showDetail }
    }

    override fun getItemCount(): Int = data.size

    open fun printLog(msg: String) {
        println("${javaClass.simpleName}: $msg")
    }

}