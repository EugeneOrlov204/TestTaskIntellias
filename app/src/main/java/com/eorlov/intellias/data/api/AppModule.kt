package com.eorlov.intellias.data.api

import com.eorlov.intellias.data.mappers.WordDataMapper
import com.eorlov.intellias.data.repositories.words.WordLocalDataSource
import com.eorlov.intellias.data.repositories.words.WordRemoteDataSource
import com.eorlov.intellias.data.repositories.words.WordRemoteDataSourceImpl
import com.eorlov.intellias.data.repositories.words.WordRepositoryImpl
import com.eorlov.intellias.domain.repositories.WordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val BASE_URL = "https://api.dictionaryapi.dev/"

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideMainService(retrofit: Retrofit): MainService =
        retrofit.create(MainService::class.java)

    @Provides
    @Singleton
    fun provideRepository(
        remoteDataSource: WordRemoteDataSource,
        localDataSource: WordLocalDataSource,
        mapper: WordDataMapper
    ): WordRepository =
        WordRepositoryImpl(remoteDataSource, localDataSource, mapper)

    @Provides
    @Singleton
    fun provideRemoteDataSource(mainService: MainService): WordRemoteDataSource =
        WordRemoteDataSourceImpl(mainService)
}