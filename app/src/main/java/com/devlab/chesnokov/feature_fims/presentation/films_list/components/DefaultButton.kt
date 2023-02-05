package com.devlab.chesnokov.feature_fims.presentation.films_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DefaultButton(
    text: String,
    color: Color,
    backgroundColor: Color,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier
            .wrapContentSize()
            .background(backgroundColor),
        onClick = onClick,
        shape = CircleShape
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            color = color,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 35.dp, vertical = 8.dp),
        )
    }
}