package com.eorlov.data.repositories.words

import com.eorlov.domain.entities.Word

interface WordLocalDataSource {
    suspend fun add(word: Word)

    suspend fun readAll(): List<Word>

    suspend fun remove(word: Word)
}