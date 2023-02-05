package com.devlab.chesnokov.feature_fims.presentation.films_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarPurple500
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.devlab.chesnokov.feature_fims.domain.model.Film

@Composable
fun FilmItem(
    film: Film,
    modifier: Modifier = Modifier,
    onTap: () -> Unit,
    onLongPress: () -> Unit,
) {
    val isFavoriteState = remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = { onLongPress },
                    onTap = { onTap }
                )
            },
        elevation = 30.dp,
        shape = RoundedCornerShape(20.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = film.posterUrlPreview,
                contentDescription = "posterUrlPreview",
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(0.88f),
                        text = film.nameRu,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                    Image(
                        modifier = Modifier
                            .padding(start = 15.dp),
                        imageVector = Icons.Rounded.Star,
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                        contentDescription = "isFavorite",
                        alpha =
                        if (isFavoriteState.value) 1f
                        else 0f,
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "${
                        film.genres.first().replaceFirstChar { it.uppercaseChar() }
                    } (${film.year})",
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}