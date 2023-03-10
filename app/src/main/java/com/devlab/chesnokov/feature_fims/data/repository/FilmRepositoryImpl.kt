package com.devlab.chesnokov.feature_fims.data.repository

import com.devlab.chesnokov.feature_fims.data.data_source.FilmDao
import com.devlab.chesnokov.feature_fims.domain.model.Film
import com.devlab.chesnokov.feature_fims.domain.repository.FilmRepository
import kotlinx.coroutines.flow.Flow

class FilmRepositoryImpl(
    private val dao: FilmDao
): FilmRepository {

    override fun getFilms(): Flow<List<Film>> {
        return dao.getFilms()
    }

    override fun getFavoriteFilms(): Flow<List<Film>> {
        return dao.getFavoriteFilms()
    }

    override suspend fun getFilmById(id: Int): Film? {
        return dao.getFilmById(id)
    }

    override suspend fun insertFilm(film: Film) {
        dao.insertFilm(film)
    }

    override suspend fun deleteFilm(film: Film) {
        dao.deleteFilm(film)
    }
}