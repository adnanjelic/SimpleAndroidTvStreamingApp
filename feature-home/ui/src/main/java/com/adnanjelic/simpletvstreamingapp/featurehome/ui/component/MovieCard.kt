package com.adnanjelic.simpletvstreamingapp.featurehome.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import coil.compose.AsyncImage
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.MovieUiModel

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
internal fun MovieCard(
    movie: MovieUiModel,
    onClick: (MovieUiModel) -> Unit = {}
) {
    Card(
        onClick = { onClick(movie) }
    ) {
        AsyncImage(
            model = movie.posterUrl,
            modifier = Modifier.fillMaxSize(),
            contentDescription = movie.title,
            contentScale = ContentScale.Crop
        )
    }
}
