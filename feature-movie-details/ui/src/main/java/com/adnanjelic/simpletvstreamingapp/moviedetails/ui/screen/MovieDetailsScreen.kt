package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavHostController
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.R
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component.DefaultSpacer
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component.MovieAttributeRow
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component.MovieDescription
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.model.MovieDetailsUiModel
import com.adnanjelic.simpletvstreamingapp.theme.Dimension

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MovieDetailsScreen(navHostController: NavHostController, movieId: String?) {
    val movie = MovieDetailsUiModel(
        id = "281",
        title = "Mission: Impossible - Dead Reckoning Part One",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        posterUrl = "https://www.closeup-shop.com/media/oart_0/oart_m/oart_14146/1023019_G524780.JPG",
        duration = "1:55:33",
        rating = "9.11"
    )

    Box {
        AsyncImage(
            model = movie.posterUrl,
            modifier = Modifier.fillMaxSize(),
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter
        )

        Text("MovieDetailsScreen, movieId: $movieId", color = Color.White)

        Button(
            modifier = Modifier.padding(Dimension.Padding.Big),
            onClick = { navHostController.popBackStack() }
        ) {
            Text("Back")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimension.Padding.Big),
            verticalArrangement = Arrangement.Bottom
        ) {
            MovieAttributeRow(
                headerResourceId = R.string.title_label,
                text = movie.title,
                textStyle = MaterialTheme.typography.bodyLarge
            )
            DefaultSpacer()
            MovieAttributeRow(headerResourceId = R.string.duration_label, text = movie.duration)
            MovieAttributeRow(headerResourceId = R.string.rating_label, text = movie.rating)
            DefaultSpacer()
            MovieDescription(text = movie.description)
            DefaultSpacer()
            Button(onClick = { }) {
                Text("Play")
            }
        }
    }
}
