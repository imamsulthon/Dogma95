package com.mamski.dogma95.ui.adapter

import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.databinding.AdapterMovieBinding
import kotlinx.android.synthetic.main.adapter_movie.view.*

class ShowCaseVH(view: AdapterMovieBinding): BaseShowCaseVH<Movie>(view) {

    override fun bind(item: Movie) {
        printLog("bind ${item.title}")
        with(itemView) {
            tvTitle.text = item.title
        }
    }
}