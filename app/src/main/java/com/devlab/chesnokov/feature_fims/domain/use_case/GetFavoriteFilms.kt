package com.devlab.chesnokov.feature_fims.domain.use_case

import com.devlab.chesnokov.feature_fims.domain.model.Film
import com.devlab.chesnokov.feature_fims.domain.repository.FilmRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteFilms(
    private val repository: FilmRepository
) {

    operator fun invoke(): Flow<List<Film>> {
        return repository.getFavoriteFilms()
    }
}