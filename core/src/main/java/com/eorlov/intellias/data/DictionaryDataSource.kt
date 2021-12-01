package com.eorlov.intellias.data

import com.eorlov.intellias.domain.Dictionary

interface DictionaryDataSource {
    suspend fun add(dictionary: Dictionary)

    suspend fun readAll(): List<Dictionary>

    suspend fun remove(dictionary: Dictionary)
}