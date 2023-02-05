package com.devlab.chesnokov.feature_fims.presentation.films_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.devlab.chesnokov.feature_fims.domain.util.FilmFilter

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier,
    filmFilter: FilmFilter = FilmFilter.Top,
    onFilterChange: (FilmFilter) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DefaultButton(
            text = "Популярные",
            color = MaterialTheme.colors.primary,
            backgroundColor = MaterialTheme.colors.secondary,
            onClick = { onFilterChange(FilmFilter.Top) },
        )
        DefaultButton(
            text = "Избранное",
            color = Color.White,
            backgroundColor = MaterialTheme.colors.primary,
            onClick = { onFilterChange(FilmFilter.Favorite) },
        )
    }
}