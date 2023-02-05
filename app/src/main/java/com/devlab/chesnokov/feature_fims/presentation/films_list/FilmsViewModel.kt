package com.devlab.chesnokov.feature_fims.presentation.films_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devlab.chesnokov.feature_fims.domain.use_case.FilmUseCases
import com.devlab.chesnokov.feature_fims.domain.util.FilmFilter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val filmUseCases: FilmUseCases
) : ViewModel() {

    private val _state = mutableStateOf(FilmsState())
    val state: State<FilmsState> = _state

    private var getFilmsJob: Job? = null

    init {
        getFilms(FilmFilter.Top)
    }

    fun onEvent(event: FilmsEvent) {
        when (event) {
            is FilmsEvent.ChangeFavoriteStatus -> {
                viewModelScope.launch {
                    filmUseCases.changeFavoriteStatus
                }
            }
            is FilmsEvent.ToggleFilter -> {
                if (state.value.filmFilter::class == event.filmFilter) {
                    return
                }
                getFilms(event.filmFilter)
            }
        }
    }

    private fun getFilms(filmFilter: FilmFilter) {
        getFilmsJob?.cancel()
        getFilmsJob = filmUseCases.getFilms(filmFilter).onEach { films ->
            _state.value = state.value.copy(films = films, filmFilter = filmFilter)
        }.launchIn(viewModelScope)
    }
}