package com.eorlov.intellias.data.entities

import androidx.room.Entity

@Entity
data class WordInfo(
    val meanings: List<Meaning>,
    val phonetic: String,
    val word: String
)