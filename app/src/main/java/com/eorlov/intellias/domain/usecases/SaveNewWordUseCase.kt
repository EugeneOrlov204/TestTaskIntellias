package com.eorlov.intellias.domain.usecases

import com.eorlov.intellias.domain.entities.Word
import com.eorlov.intellias.domain.repositories.WordRepository

class SaveNewWordUseCase(private val wordRepository: WordRepository) {
    suspend fun invoke(word: Word) = wordRepository.saveWord(word)
}