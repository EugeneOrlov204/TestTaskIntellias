package com.eorlov.data.repositories.words

import com.eorlov.domain.entities.Word
import com.eorlov.domain.repositories.WordRepository


open class WordRepositoryImpl(private val localDataSource: WordLocalDataSource) : WordRepository {
    override suspend fun addWord(word: Word) = localDataSource.add(word)

    override suspend fun getWords(): List<Word> = localDataSource.readAll()

    override suspend fun removeWord(word: Word) = localDataSource.remove(word)
}