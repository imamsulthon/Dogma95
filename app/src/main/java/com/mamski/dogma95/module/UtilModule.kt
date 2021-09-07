package com.mamski.dogma95.module

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.paging.PagedList
import androidx.preference.PreferenceManager
import com.mamski.dogma95.data.database.AppRoomDatabase
import com.mamski.dogma95.data.network.AppCoroutineDispatchers
import com.mamski.dogma95.data.network.AppRxSchedulers
import com.mamski.dogma95.ui.settings.PrefsHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class UtilModule {

    @Provides
    @Singleton
    fun provideConfig() : PagedList.Config = PagedList.Config.Builder()
        .setPageSize(1)
        .setInitialLoadSizeHint(2)
        .setPrefetchDistance(1)
        .setEnablePlaceholders(false)
        .build()

    @Provides
    @Singleton
    fun providesDataBase(@ApplicationContext context: Context): AppRoomDatabase = AppRoomDatabase(
        context
    )

    @Singleton
    @Provides
    fun providesPreferenceManager(@ApplicationContext context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    @Singleton
    @Provides
    fun providesPrefsHelper(@ApplicationContext context: Context): PrefsHelper = PrefsHelper(context)

//    @Singleton
//    @Provides
//    fun providesRxSchedulers() = AppRxSchedulers(
//        database = Schedulers.single(),
//        disk = Schedulers.io(),
//        network = Schedulers.io(),
//        main = AndroidSchedulers.mainThread()
//    )
//
//    @Singleton
//    @Provides
//    fun providesCoroutineDispatchers(schedulers: AppRxSchedulers) = AppCoroutineDispatchers(
//        database = schedulers.database as CoroutineDispatcher,
//        disk = schedulers.disk as CoroutineDispatcher,
//        network = schedulers.network as CoroutineDispatcher,
//        main = schedulers.main as CoroutineDispatcher
//    )

}