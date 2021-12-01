package com.eorlov.intellias.data

import com.eorlov.intellias.domain.Word


class WordRepository(private val dataSource: WordDataSource) {
    suspend fun addWord(word: Word) = dataSource.add(word)

    suspend fun getWords() = dataSource.readAll()

    suspend fun removeWord(word: Word) = dataSource.remove(word)
}