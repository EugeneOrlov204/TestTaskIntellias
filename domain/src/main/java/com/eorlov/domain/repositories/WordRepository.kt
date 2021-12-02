package com.eorlov.domain.repositories

import com.eorlov.domain.entities.Word

interface WordRepository {
    suspend fun addWord(word: Word)
    suspend fun getWords() : List<Word>
    suspend fun removeWord(word: Word)
}