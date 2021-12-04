package com.eorlov.intellias.domain.usecases

import com.eorlov.intellias.domain.entities.Word
import com.eorlov.intellias.domain.repositories.WordRepository

class GetNewWordUseCaseFromDatabase(private val wordRepository: WordRepository) {
    suspend fun invoke(word: String) : Word? = wordRepository.getWordFromDatabase(word)
}