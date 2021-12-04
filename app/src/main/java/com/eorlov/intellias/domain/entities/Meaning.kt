package com.eorlov.intellias.domain.entities

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)