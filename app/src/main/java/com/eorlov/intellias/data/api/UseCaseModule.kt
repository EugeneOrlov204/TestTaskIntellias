package com.eorlov.intellias.data.api

import com.eorlov.intellias.domain.repositories.WordRepository
import com.eorlov.intellias.domain.usecases.GetNewWordUseCaseFromDatabase
import com.eorlov.intellias.domain.usecases.GetNewWordUseCaseFromDictionary
import com.eorlov.intellias.domain.usecases.SaveNewWordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetNewWordUseCaseFromDictionary(wordRepository: WordRepository): GetNewWordUseCaseFromDictionary =
        GetNewWordUseCaseFromDictionary(wordRepository)

    @Provides
    fun provideSaveNewWordUseCase(wordRepository: WordRepository): SaveNewWordUseCase =
        SaveNewWordUseCase(wordRepository)

    @Provides
    fun provideGetNewWordUseCaseFromDatabase(wordRepository: WordRepository): GetNewWordUseCaseFromDatabase =
        GetNewWordUseCaseFromDatabase(wordRepository)
}