package com.mamski.dogma95.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mamski.dogma95.BuildConfig
import com.mamski.dogma95.data.database.dao.MovieDao
import com.mamski.dogma95.data.database.entity.MovieEntity


@Database(
    entities = [MovieEntity::class],
    version = BuildConfig.VERSION_CODE
)
abstract class AppRoomDatabase: RoomDatabase() {

    abstract fun movie(): MovieDao

    companion object {

        @Volatile
        private var instance: AppRoomDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppRoomDatabase::class.java,
            BuildConfig.APPLICATION_ID
        )
            .fallbackToDestructiveMigration()
            .build()
    }

}