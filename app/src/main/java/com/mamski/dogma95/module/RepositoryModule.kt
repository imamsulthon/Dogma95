package com.mamski.dogma95.module

import androidx.paging.PagedList
import com.mamski.dogma95.data.database.AppRoomDatabase
import com.mamski.dogma95.data.factory.MovieDataFactory
import com.mamski.dogma95.data.network.ApiService
import com.mamski.dogma95.data.repo.DataRepository
import com.mamski.dogma95.data.repo.local.LocalRepository
import com.mamski.dogma95.data.repo.remote.RemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesRemoteRepository(apiService: ApiService, config: PagedList.Config, factory: MovieDataFactory
    ): RemoteRepository = RemoteRepository(
        apiService, config, factory
    )

    @Singleton
    @Provides
    fun providesLocalRepository(database: AppRoomDatabase, config: PagedList.Config
    ) : LocalRepository = LocalRepository(database, config)

    @Singleton
    @Provides
    fun providesDataRepository(remoteRepository: RemoteRepository, localRepository: LocalRepository
    ) : DataRepository = DataRepository(
        remoteRepository, localRepository
    )
}