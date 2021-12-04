package com.eorlov.intellias.presentation.mappers

import com.eorlov.intellias.domain.entities.Word
import com.eorlov.intellias.presentation.entities.DefinitionInfo
import com.eorlov.intellias.presentation.entities.MeaningInfo
import com.eorlov.intellias.presentation.entities.WordInfo
import javax.inject.Inject

class WordInfoMapper @Inject constructor() {
    fun fromWordToWordInfo(word: Word): WordInfo {
        val meanings = mutableListOf<MeaningInfo>()

        for (meaning in word.meanings) {

            val definitions = mutableListOf<DefinitionInfo>()

            for (definition in meaning.definitions) {
                definitions.add(DefinitionInfo(definition.definition))
            }

            meanings.add(
                MeaningInfo(
                    definitions,
                    meaning.partOfSpeech
                )
            )
        }

        return WordInfo(
            word = word.word,
            phonetic = word.phonetics[0].text,
            meaningInfos = meanings
        )
    }
}