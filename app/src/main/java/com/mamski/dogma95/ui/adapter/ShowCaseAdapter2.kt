package com.mamski.dogma95.ui.adapter

import android.view.ViewGroup
import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.databinding.AdapterMovieBinding

class ShowCaseAdapter2: BasicAdapter<Movie>() {

    override fun getViewHolder(view: ViewGroup): BaseViewHolder<Movie> = ExampleViewHolder(
        AdapterMovieBinding.bind(view)
    )

    override fun handleOtherBinding() {

    }

}