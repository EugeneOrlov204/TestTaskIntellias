package com.eorlov.intellias.domain.usecases

import com.eorlov.intellias.domain.repositories.WordRepository

class GetNewWordUseCaseFromDictionary(private val wordRepository: WordRepository) {
    suspend fun invoke(word: String) = wordRepository.getWord(word)
}