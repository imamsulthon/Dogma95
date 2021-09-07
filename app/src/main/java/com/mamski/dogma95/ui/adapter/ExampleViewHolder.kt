package com.mamski.dogma95.ui.adapter

import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mamski.dogma95.BuildConfig
import com.mamski.dogma95.data.model.movie.Movie
import kotlinx.android.synthetic.main.adapter_showcase.view.*

class ExampleViewHolder(view: ViewBinding) : BaseViewHolder<Movie>(view.root) {

    override fun bind(item: Movie) {
        printLog("bind ${item.title} ${item.posterPath}")
        with (itemView) {
            Glide.with(context)
                .load(BuildConfig.IMAGE_API_KEY + item.posterPath)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgPoster)
            tvTitle.text = item.title
        }
    }
}