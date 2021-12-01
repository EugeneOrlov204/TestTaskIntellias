package com.eorlov.intellias.domain

data class Dictionary(
    val meanings: List<Meaning>,
    val phonetics: List<Phonetic>,
    val word: String
)