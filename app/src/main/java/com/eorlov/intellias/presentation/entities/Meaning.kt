package com.eorlov.intellias.presentation.entities

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)