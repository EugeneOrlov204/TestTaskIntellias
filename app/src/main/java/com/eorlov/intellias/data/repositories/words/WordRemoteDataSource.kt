package com.eorlov.intellias.data.repositories.words

import com.eorlov.intellias.domain.entities.Word
import com.eorlov.intellias.domain.common.Result

interface WordRemoteDataSource {
    suspend fun get(word: String) : Result<Word>
}