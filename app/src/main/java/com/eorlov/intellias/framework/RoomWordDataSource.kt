package com.eorlov.intellias.framework

import com.eorlov.intellias.data.WordDataSource
import com.eorlov.intellias.domain.Word

class RoomWordDataSource : WordDataSource {
    override suspend fun add(word: Word) {
        TODO("Not yet implemented")
    }

    override suspend fun readAll(): List<Word> {
        TODO("Not yet implemented")
    }

    override suspend fun remove(word: Word) {
        TODO("Not yet implemented")
    }

}