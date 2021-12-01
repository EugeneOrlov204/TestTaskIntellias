package com.eorlov.intellias.domain

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)