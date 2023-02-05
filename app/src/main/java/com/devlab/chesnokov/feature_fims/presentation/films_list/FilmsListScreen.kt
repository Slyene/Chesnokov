package com.devlab.chesnokov.feature_fims.presentation.films_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devlab.chesnokov.feature_fims.domain.use_case.GetFavoriteFilms
import com.devlab.chesnokov.feature_fims.presentation.films_list.components.ButtonSection
import com.devlab.chesnokov.feature_fims.presentation.films_list.components.FilmItem

@Composable
fun FilmsListScreen(
    navController: NavController,
    viewModel: FilmsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(state.films) { film ->
            FilmItem(
                film = film,
                onTap = {

                },
                onLongPress = {
                    viewModel.onEvent(FilmsEvent.ChangeFavoriteStatus(film))
                }
            )
        }
    }
    //ButtonSection(onFilterChange = )
}