package com.eorlov.intellias.data

import com.eorlov.intellias.domain.Word

interface WordDataSource {
    suspend fun add(word: Word)

    suspend fun readAll(): List<Word>

    suspend fun remove(word: Word)
}