package com.eorlov.intellias.presentation.mappers

import com.eorlov.intellias.domain.entities.Word
import com.eorlov.intellias.presentation.entities.Definition
import com.eorlov.intellias.presentation.entities.Meaning
import com.eorlov.intellias.presentation.entities.WordInfo
import javax.inject.Inject

class WordInfoMapper @Inject constructor() {
    fun fromWordToWordInfo(word: Word): WordInfo {
        val meanings = mutableListOf<Meaning>()

        for (meaning in word.meanings) {

            val definitions = mutableListOf<Definition>()

            for (definition in meaning.definitions) {
                definitions.add(Definition(definition.definition))
            }

            meanings.add(
                Meaning(
                    definitions,
                    meaning.partOfSpeech
                )
            )
        }

        return WordInfo(
            word = word.word,
            phonetic = word.phonetics[0].text,
            meanings = meanings
        )
    }
}