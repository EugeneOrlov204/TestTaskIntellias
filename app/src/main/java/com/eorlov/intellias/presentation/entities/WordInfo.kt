package com.eorlov.intellias.presentation.entities

data class WordInfo(
    val meaningInfos: List<MeaningInfo>,
    val phonetic: String,
    val word: String
)