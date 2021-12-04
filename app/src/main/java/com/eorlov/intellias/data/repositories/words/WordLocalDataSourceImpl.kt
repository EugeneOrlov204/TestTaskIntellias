package com.eorlov.intellias.data.repositories.words

import com.eorlov.intellias.data.db.WordDataDao
import com.eorlov.intellias.data.entities.WordData
import javax.inject.Inject

class WordLocalDataSourceImpl @Inject constructor(
    private val dao: WordDataDao
) :
    WordLocalDataSource {
    override suspend fun get(word: String): WordData? {
        return dao.get(word)
    }

    override suspend fun insert(wordData: WordData) {
        dao.insert(wordData)
    }
}