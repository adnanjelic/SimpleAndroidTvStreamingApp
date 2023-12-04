package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MovieDetailsScreen(navHostController: NavHostController, movieId: String?) {
    Column {
        Text("MovieDetailsScreen, movieId: $movieId", color = Color.White)
        Button(onClick = { navHostController.popBackStack() }) {
            Text("Navigate back")
        }
    }
}
