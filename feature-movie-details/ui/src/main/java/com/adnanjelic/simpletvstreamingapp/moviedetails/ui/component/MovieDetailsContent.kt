package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.R
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.model.MovieDetailsUiModel
import com.adnanjelic.simpletvstreamingapp.theme.Dimension

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
internal fun MovieDetailsContent(
    isVisible: Boolean,
    movieDetails: MovieDetailsUiModel?,
    onNavigateBackSelected: () -> Unit = {},
    onPlayMovieSelected: (String) -> Unit = {}
) {
    if (movieDetails == null) return

    AnimatedVisibility(visible = isVisible) {
        Row {
            AsyncImage(
                modifier = Modifier.weight(1f),
                model = movieDetails.posterUrl,
                contentDescription = movieDetails.title,
                contentScale = ContentScale.FillHeight
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = Dimension.Padding.Big)
            ) {
                Button(onClick = onNavigateBackSelected) {
                    Text(stringResource(id = R.string.back_label))
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = Dimension.Padding.Big),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    MovieAttributeRow(
                        headerResourceId = R.string.title_label,
                        text = movieDetails.title,
                        textStyle = MaterialTheme.typography.bodyLarge
                    )
                    DefaultSpacer()
                    MovieAttributeRow(
                        headerResourceId = R.string.duration_label,
                        text = movieDetails.duration
                    )
                    MovieAttributeRow(
                        headerResourceId = R.string.rating_label,
                        text = movieDetails.rating
                    )
                    DefaultSpacer()
                    MovieDescription(text = movieDetails.description)
                    DefaultSpacer()
                    Button(onClick = { onPlayMovieSelected(movieDetails.id) }) {
                        Text(stringResource(id = R.string.play_movie_label))
                    }
                }
            }
        }
    }
}
