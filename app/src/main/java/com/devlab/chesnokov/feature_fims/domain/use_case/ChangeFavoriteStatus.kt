package com.devlab.chesnokov.feature_fims.domain.use_case

import com.devlab.chesnokov.feature_fims.domain.model.Film
import com.devlab.chesnokov.feature_fims.domain.repository.FilmRepository

class ChangeFavoriteStatus(
    private val repository: FilmRepository
) {

    suspend operator fun invoke(film: Film) {
        repository.insertFilm(film.copy(isFavorite = !film.isFavorite))
    }
}