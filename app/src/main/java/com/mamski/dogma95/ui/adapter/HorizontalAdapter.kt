package com.mamski.dogma95.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mamski.dogma95.BuildConfig.IMAGE_API_KEY
import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.databinding.AdapterMovieBinding

class HorizontalAdapter(val showDetail: (Movie) -> Unit
): PagedListAdapter<Movie, HorizontalAdapter.ViewHolder>(DIFF_CALLBACK) {

    private val data = ArrayList<Movie>()

    companion object{
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<Movie>(){
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        AdapterMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        with(holder.view) {
            holder.bindView(item)
            root.setOnClickListener {
                showDetail(data[position])
            }
        }
    }

    class ViewHolder(val view: AdapterMovieBinding): RecyclerView.ViewHolder(view.root) {

        fun bindView(item: Movie) {
            with(view) {
                tvTitle.text = item.title
                itemView.also {
                    Glide.with(it.context)
                        .load(IMAGE_API_KEY + item.posterPath)
                        .into(imgPoster)
                }
            }
        }
    }

}