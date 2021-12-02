package com.eorlov.domain.entities

data class Definition(
    val definition: String,
    val example: String,
    val synonyms: List<String>
)