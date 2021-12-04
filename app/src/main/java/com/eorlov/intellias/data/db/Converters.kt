package com.eorlov.intellias.data.db

import androidx.room.TypeConverter
import com.eorlov.intellias.data.entities.MeaningData
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {

    @TypeConverter
    fun fromMeaningsDataList(value: List<MeaningData>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toMeaningsDataList(value: String): List<MeaningData> {
        val listType: Type = object : TypeToken<List<MeaningData>>() {}.type
        return Gson().fromJson(value, listType)
    }
}