package com.eorlov.intellias.data.repositories.words

import com.eorlov.intellias.domain.common.Result
import com.eorlov.intellias.domain.entities.Word

interface WordRemoteDataSource {
    suspend fun get(word: String) : Result<Word>
}