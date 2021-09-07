package com.mamski.dogma95.data.model.state

import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.data.model.response.MainResponse

sealed class MovieDataState {
    object Loading: MovieDataState()
    data class Result(val data: MainResponse<Movie>): MovieDataState()
    data class Error(val error: Throwable): MovieDataState()
}
