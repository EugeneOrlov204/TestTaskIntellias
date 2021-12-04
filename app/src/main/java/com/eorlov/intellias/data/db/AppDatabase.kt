package com.eorlov.intellias.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.eorlov.intellias.data.entities.WordData

@Database(entities = [WordData::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wordInfoDao(): WordDataDao
}