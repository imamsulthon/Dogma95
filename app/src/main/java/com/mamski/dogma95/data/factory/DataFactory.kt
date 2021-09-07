package com.mamski.dogma95.data.factory

import javax.inject.Singleton

@Singleton
data class DataFactory (
    val movieDataFactory: MovieDataFactory,
    val nowPlayingDataFactory: NowPlayingDataFactory,
    val upcomingMovieDataFactory: UpcomingMovieDataFactory,
    val topMovieDataFactory: TopMovieDataFactory,
    val popularMovieDataFactory: PopularMovieDataFactory
)