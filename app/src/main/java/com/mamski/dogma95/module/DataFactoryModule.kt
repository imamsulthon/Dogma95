package com.mamski.dogma95.module

import com.mamski.dogma95.data.factory.*
import com.mamski.dogma95.data.source.*
import com.mamski.dogma95.data.source.movie.NowPlayingMovieDataSource
import com.mamski.dogma95.data.source.movie.PopularMovieDataSource
import com.mamski.dogma95.data.source.movie.TopRatedMovieDataSource
import com.mamski.dogma95.data.source.movie.UpcomingMovieDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class DataFactoryModule {

    @Singleton
    @Provides
    fun provideFactory(
        movieDataFactory: MovieDataFactory,
        popularMovieDataFactory: PopularMovieDataFactory,
        topMovieDataFactory: TopMovieDataFactory,
        nowPlayingDataFactory: NowPlayingDataFactory,
        upcomingMovieDataFactory: UpcomingMovieDataFactory
    ): DataFactory = DataFactory(
        movieDataFactory = movieDataFactory,
        popularMovieDataFactory = popularMovieDataFactory,
        topMovieDataFactory = topMovieDataFactory,
        nowPlayingDataFactory = nowPlayingDataFactory,
        upcomingMovieDataFactory = upcomingMovieDataFactory
    )

    @Singleton
    @Provides
    fun providesMainMovieDataFactory(dataSource: MovieDataSource
    ) : MovieDataFactory = MovieDataFactory(dataSource)

    @Singleton
    @Provides
    fun providesPopularMovieDataFactory(dataSource: PopularMovieDataSource
    ): PopularMovieDataFactory = PopularMovieDataFactory(dataSource)

    @Singleton
    @Provides
    fun providesTopRatedMovieDataFactory(dataSource: TopRatedMovieDataSource
    ): TopMovieDataFactory = TopMovieDataFactory(dataSource)

    @Singleton
    @Provides
    fun providesUpcomingMovieDataFactory(dataSource: UpcomingMovieDataSource)
    : UpcomingMovieDataFactory = UpcomingMovieDataFactory(dataSource)

    @Singleton
    @Provides
    fun providesNowPlayingMovieDataFactory(dataSource: NowPlayingMovieDataSource
    ) : NowPlayingDataFactory = NowPlayingDataFactory(dataSource)

}