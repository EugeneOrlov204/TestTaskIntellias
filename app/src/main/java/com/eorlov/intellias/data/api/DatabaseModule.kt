package com.eorlov.intellias.data.api

import android.content.Context
import androidx.room.Room
import com.eorlov.intellias.data.db.AppDatabase
import com.eorlov.intellias.data.db.WordDataDao
import com.eorlov.intellias.data.repositories.words.WordLocalDataSource
import com.eorlov.intellias.data.repositories.words.WordLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideWordInfoDao(appDatabase: AppDatabase): WordDataDao {
        return appDatabase.wordInfoDao()
    }


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "RssReader"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(dao: WordDataDao): WordLocalDataSource =
        WordLocalDataSourceImpl(dao)
}