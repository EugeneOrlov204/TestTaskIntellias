package com.eorlov.intellias.domain

data class Word(
    val meanings: List<Meaning>,
    val phonetics: List<Phonetic>,
    val word: String
)