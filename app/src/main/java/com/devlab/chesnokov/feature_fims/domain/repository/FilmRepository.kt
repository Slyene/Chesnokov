package com.devlab.chesnokov.feature_fims.domain.repository

import com.devlab.chesnokov.feature_fims.domain.model.Film
import kotlinx.coroutines.flow.Flow

interface FilmRepository {

    fun getFilms(): Flow<List<Film>>

    fun getFavoriteFilms(): Flow<List<Film>>

    suspend fun getFilmById(id: Int): Film?

    suspend fun insertFilm(film: Film)

    suspend fun deleteFilm(film: Film)
}