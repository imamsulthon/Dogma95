package com.mamski.dogma95.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mamski.dogma95.R
import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.ui.adapter.MovieAdapter

class BoardActivity : AppCompatActivity() {

    private val movieAdapter: MovieAdapter by lazy {
        MovieAdapter { item -> detailMovie(item) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)
    }

    fun detailMovie(movie: Movie) {

    }

}