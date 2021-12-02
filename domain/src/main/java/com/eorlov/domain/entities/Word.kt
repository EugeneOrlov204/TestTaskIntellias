package com.eorlov.domain.entities

data class Word(
    val meanings: List<Meaning>,
    val phonetics: List<Phonetic>,
    val word: String
)