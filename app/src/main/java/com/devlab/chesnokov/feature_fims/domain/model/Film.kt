package com.devlab.chesnokov.feature_fims.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Film(
    @PrimaryKey val filmId: Int? = null,
    val nameRu: String,
    val description: String,
    val year: Int,
    val countries: List<String>,
    val genres: List<String>,
    val posterUrl: String,
    val posterUrlPreview: String,
    val isFavorite: Boolean = false,
)

class InvalidFilmException(message: String): Exception(message)
