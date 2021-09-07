package com.mamski.dogma95.module

import com.mamski.dogma95.data.repo.BaseRepository
import com.mamski.dogma95.data.repo.DataRepository
import com.mamski.dogma95.data.repo.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class BindingModule {

    @Binds
    abstract fun bindRepository(dataRepository: DataRepository): BaseRepository

//    @Binds
//    abstract fun bindMovieRepository(dataRepository: DataRepository): MovieRepository

}