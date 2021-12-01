package com.eorlov.intellias.interactors

import com.eorlov.intellias.data.WordRepository
import com.eorlov.intellias.domain.Word

class AddNewWord(private val wordRepository: WordRepository) {
    suspend operator fun invoke(word: Word) = wordRepository.addWord(word)
}