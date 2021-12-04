package com.eorlov.intellias.domain.repositories

import com.eorlov.intellias.domain.entities.Word
import com.eorlov.intellias.domain.common.Result

interface WordRepository {
    suspend fun getWord(word: String) : Result<Word>
}