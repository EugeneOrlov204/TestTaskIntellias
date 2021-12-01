package com.eorlov.intellias.domain

data class Definition(
    val definition: String,
    val example: String,
    val synonyms: List<String>
)