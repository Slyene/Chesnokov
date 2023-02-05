package com.devlab.chesnokov.feature_fims.presentation.films_list

import com.devlab.chesnokov.feature_fims.domain.model.Film
import com.devlab.chesnokov.feature_fims.domain.util.FilmFilter

sealed class FilmsEvent {
    data class ChangeFavoriteStatus(val film: Film): FilmsEvent()
    data class ToggleFilter(val filmFilter: FilmFilter): FilmsEvent()
}
