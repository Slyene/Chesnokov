package com.devlab.chesnokov.feature_fims.domain.util

sealed class FilmFilter {
    object Top: FilmFilter()
    object Favorite: FilmFilter()
}
