package com.eorlov.intellias.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WordData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val meaningData: List<MeaningData>,
    val phonetic: String,
    val word: String
)