package com.devlab.chesnokov.feature_fims.domain.use_case

import com.devlab.chesnokov.feature_fims.domain.model.Film
import com.devlab.chesnokov.feature_fims.domain.repository.FilmRepository

class GetFilmById(
    private val repository: FilmRepository
) {

    suspend operator fun invoke(id: Int): Film? {
        return repository.getFilmById(id)
    }
}