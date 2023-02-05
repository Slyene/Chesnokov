package com.devlab.chesnokov.feature_fims.domain.use_case

data class FilmUseCases(
    val changeFavoriteStatus: ChangeFavoriteStatus,
    val getFilms: GetFilms,
    val getFavoriteFilms: GetFavoriteFilms,
    val getFilmById: GetFilmById,
)
