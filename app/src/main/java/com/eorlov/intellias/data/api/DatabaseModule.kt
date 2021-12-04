package com.eorlov.intellias.data.api

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    //fixme
//    @Provides
//    fun provideUserDao(appDatabase: AppDatabase): UserDao {
//        return appDatabase.userDao()
//    }
//
//    @Provides
//    fun providePhotoDao(appDatabase: AppDatabase): PhotoDao {
//        return appDatabase.photoDao()
//    }
//
//    @Provides
//    @Singleton
//    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
//        return Room.databaseBuilder(
//            appContext,
//            AppDatabase::class.java,
//            "RssReader"
//        ).fallbackToDestructiveMigration().build()
//    }

//    @Provides
//    @Singleton
//    fun provideLocalDataSource(mainService: MainService): WordRemoteDataSource =
//        WordRemoteDataSourceImpl(mainService)
}