package com.eorlov.intellias.data.api

import com.eorlov.intellias.domain.repositories.WordRepository
import com.eorlov.intellias.domain.usecases.GetNewWordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetNewWordUseCase(wordRepository: WordRepository): GetNewWordUseCase =
        GetNewWordUseCase(wordRepository)
}