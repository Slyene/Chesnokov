package com.devlab.chesnokov.feature_fims.data.data_source

import androidx.room.TypeConverter

class StringListConverter {

    @TypeConverter
    fun fromStringList(stringList: List<String?>): String {
        return stringList.joinToString(separator = ",")
    }

    @TypeConverter
    fun toStringList(data: String): List<String?> {
        return data.split(",")
    }
}