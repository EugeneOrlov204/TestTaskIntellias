package com.eorlov.intellias.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eorlov.intellias.data.entities.WordData

@Dao
interface WordDataDao {
    @Query("SELECT * FROM worddata WHERE word = :word")
    suspend fun get(word: String): WordData?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(wordData: WordData)
}