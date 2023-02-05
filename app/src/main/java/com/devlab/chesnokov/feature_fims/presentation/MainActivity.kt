package com.devlab.chesnokov.feature_fims.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.devlab.chesnokov.feature_fims.domain.model.Film
import com.devlab.chesnokov.feature_fims.presentation.films_list.FilmsEvent
import com.devlab.chesnokov.feature_fims.presentation.films_list.FilmsListScreen
import com.devlab.chesnokov.feature_fims.presentation.films_list.components.ButtonSection
import com.devlab.chesnokov.feature_fims.presentation.films_list.components.DefaultButton
import com.devlab.chesnokov.feature_fims.presentation.films_list.components.FilmItem
import com.devlab.chesnokov.ui.theme.ChesnokovTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChesnokovTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FilmsListScreen(navController = NavController(this))
                }
            }
        }
    }
}