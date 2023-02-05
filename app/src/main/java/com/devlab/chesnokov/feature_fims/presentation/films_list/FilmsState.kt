package com.devlab.chesnokov.feature_fims.presentation.films_list

import com.devlab.chesnokov.feature_fims.domain.model.Film
import com.devlab.chesnokov.feature_fims.domain.util.FilmFilter

data class FilmsState(
    val films: List<Film> = emptyList(),
    val filmFilter: FilmFilter = FilmFilter.Top,
)
