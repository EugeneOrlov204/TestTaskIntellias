package com.eorlov.intellias.presentation.entities

data class WordInfo(
    val meanings: List<Meaning>,
    val phonetic: String,
    val word: String
)