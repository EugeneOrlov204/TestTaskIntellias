package com.eorlov.intellias.data.repositories.words

import com.eorlov.intellias.domain.entities.Word
import com.eorlov.intellias.domain.common.Result
import com.eorlov.intellias.domain.repositories.WordRepository
import javax.inject.Inject


open class WordRepositoryImpl @Inject constructor(
    private val remoteDataSource: WordRemoteDataSource
) :
    WordRepository {
    override suspend fun getWord(word: String): Result<Word> {
        return remoteDataSource.get(word)
    }
}