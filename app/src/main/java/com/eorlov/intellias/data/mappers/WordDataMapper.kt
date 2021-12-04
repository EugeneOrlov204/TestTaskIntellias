package com.eorlov.intellias.data.mappers

import com.eorlov.intellias.data.entities.DefinitionData
import com.eorlov.intellias.data.entities.MeaningData
import com.eorlov.intellias.data.entities.WordData
import com.eorlov.intellias.domain.entities.Definition
import com.eorlov.intellias.domain.entities.Meaning
import com.eorlov.intellias.domain.entities.Phonetic
import com.eorlov.intellias.domain.entities.Word
import javax.inject.Inject

class WordDataMapper @Inject constructor() {
    fun fromWordToWordData(word: Word): WordData {
        val meanings = mutableListOf<MeaningData>()

        for (meaning in word.meanings) {

            val definitions = mutableListOf<DefinitionData>()

            for (definition in meaning.definitions) {
                definitions.add(DefinitionData(definition.definition))
            }

            meanings.add(
                MeaningData(
                    definitions,
                    meaning.partOfSpeech
                )
            )
        }

        return WordData(
            word = word.word.lowercase(),
            phonetic = word.phonetics[0].text,
            meaningData = meanings
        )
    }

    fun fromWordDataToWord(wordData: WordData?): Word? {
        if (wordData == null) return null
        val meanings = mutableListOf<Meaning>()

        for (meaning in wordData.meaningData) {

            val definitions = mutableListOf<Definition>()

            for (definition in meaning.definitionData) {
                definitions.add(
                    Definition(
                        antonyms = listOf(),
                        definition = definition.definition,
                        example = "",
                        synonyms = listOf()
                    )
                )
            }

            meanings.add(
                Meaning(
                    definitions,
                    meaning.partOfSpeech
                )
            )
        }

        return Word(
            word = wordData.word,
            phonetic = wordData.phonetic,
            meanings = meanings,
            origin = "",
            phonetics = mutableListOf(Phonetic(wordData.phonetic, ""))
        )
    }
}