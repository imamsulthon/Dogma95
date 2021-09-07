package com.mamski.dogma95.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mamski.dogma95.data.model.movie.Movie

object DiffCallback: DiffUtil.ItemCallback<Movie>(){

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}