package com.eorlov.domain.usecases

import com.eorlov.domain.entities.Word
import com.eorlov.domain.repositories.WordRepository

class AddNewWordUseCase(private val wordRepository: WordRepository) {
    suspend operator fun invoke(word: Word) = wordRepository.addWord(word)
}