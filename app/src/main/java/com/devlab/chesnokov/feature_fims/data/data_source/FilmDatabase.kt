package com.devlab.chesnokov.feature_fims.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devlab.chesnokov.feature_fims.domain.model.Film

@Database(
    entities = [Film::class],
    version = 1,
)
abstract class FilmDatabase: RoomDatabase() {

    abstract val filmDao: FilmDao

    companion object {
        const val DATABASE_NAME = "films_db"
    }
}