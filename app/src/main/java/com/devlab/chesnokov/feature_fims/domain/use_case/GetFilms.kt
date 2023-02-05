package com.devlab.chesnokov.feature_fims.domain.use_case

import com.devlab.chesnokov.feature_fims.domain.model.Film
import com.devlab.chesnokov.feature_fims.domain.repository.FilmRepository
import com.devlab.chesnokov.feature_fims.domain.util.FilmFilter
import kotlinx.coroutines.flow.Flow

class GetFilms(
    private val repository: FilmRepository
) {

    operator fun invoke(
        filmFilter: FilmFilter = FilmFilter.Top
    ): Flow<List<Film>> {
        return repository.getFilms()
    }
}