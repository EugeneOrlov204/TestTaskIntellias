package com.eorlov.intellias.data.repositories.words

import com.eorlov.intellias.data.mappers.WordDataMapper
import com.eorlov.intellias.domain.common.Result
import com.eorlov.intellias.domain.entities.Word
import com.eorlov.intellias.domain.repositories.WordRepository
import javax.inject.Inject


open class WordRepositoryImpl @Inject constructor(
    private val remoteDataSource: WordRemoteDataSource,
    private val localDataSource: WordLocalDataSource,
    private val mapper: WordDataMapper
) :
    WordRepository {
    override suspend fun getWord(word: String): Result<Word> {
        return remoteDataSource.get(word)
    }

    override suspend fun saveWord(word: Word) {
        localDataSource.insert(mapper.fromWordToWordData(word))
    }

    override suspend fun getWordFromDatabase(word: String): Word? {
        val wordData = localDataSource.get(word)
        return mapper.fromWordDataToWord(wordData)
    }

}