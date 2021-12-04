package com.eorlov.intellias.data.repositories.words

import com.eorlov.intellias.data.entities.WordData

interface WordLocalDataSource {
    suspend fun get(word: String): WordData?

    suspend fun insert(wordData: WordData)
}