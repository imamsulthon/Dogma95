package com.mamski.dogma95.module

import android.content.Context
import androidx.preference.PreferenceManager
import com.mamski.dogma95.data.network.ApiService
import com.mamski.dogma95.data.source.*
import com.mamski.dogma95.data.source.movie.NowPlayingMovieDataSource
import com.mamski.dogma95.data.source.movie.PopularMovieDataSource
import com.mamski.dogma95.data.source.movie.TopRatedMovieDataSource
import com.mamski.dogma95.data.source.movie.UpcomingMovieDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun providesMainMovieDataSource(apiService: ApiService
    ): MovieDataSource = MovieDataSource(apiService)

    @Singleton
    @Provides
    fun providesNowPlayingMovieDataSource(apiService: ApiService
    ): NowPlayingMovieDataSource = NowPlayingMovieDataSource(apiService)

    @Singleton
    @Provides
    fun providesTopRatedMovieDataSource(apiService: ApiService
    ): TopRatedMovieDataSource = TopRatedMovieDataSource(apiService)

    @Singleton
    @Provides
    fun providesUpcomingMovieDataSource(apiService: ApiService
    ): UpcomingMovieDataSource = UpcomingMovieDataSource(apiService)

    @Singleton
    @Provides
    fun providesDataSource(apiService: ApiService
    ): PopularMovieDataSource = PopularMovieDataSource(apiService)


}