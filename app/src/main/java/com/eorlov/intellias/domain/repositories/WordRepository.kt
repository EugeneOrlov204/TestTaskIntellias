package com.eorlov.intellias.domain.repositories

import com.eorlov.intellias.domain.common.Result
import com.eorlov.intellias.domain.entities.Word

interface WordRepository {
    suspend fun getWord(word: String) : Result<Word>
    suspend fun saveWord(word: Word)
    suspend fun getWordFromDatabase(word: String) : Word?
}