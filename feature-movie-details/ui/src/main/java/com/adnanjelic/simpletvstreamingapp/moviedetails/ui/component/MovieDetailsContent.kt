package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.ContentScale
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import coil.compose.AsyncImage
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.R
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.model.MovieDetailsUiModel
import com.adnanjelic.simpletvstreamingapp.shared.ui.component.DarkBackgroundPreview
import com.adnanjelic.simpletvstreamingapp.shared.ui.component.Spacer
import com.adnanjelic.simpletvstreamingapp.theme.Dimension

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
internal fun MovieDetailsContent(
    isVisible: Boolean,
    movieDetails: MovieDetailsUiModel?,
    onNavigateBackSelected: () -> Unit,
    onPlayMovieSelected: (String) -> Unit
) {
    if (movieDetails == null) return

    val playButtonRequester = remember { FocusRequester() }
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
                SelectableButton(
                    textResourceId = R.string.back_label,
                    onClick = onNavigateBackSelected
                )

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
                    Spacer()
                    MovieAttributeRow(
                        headerResourceId = R.string.duration_label,
                        text = movieDetails.duration
                    )
                    MovieAttributeRow(
                        headerResourceId = R.string.rating_label,
                        text = movieDetails.rating
                    )
                    Spacer()
                    MovieDescription(text = movieDetails.description)
                    Spacer()
                    SelectableButton(
                        modifier = Modifier.focusRequester(playButtonRequester),
                        textResourceId = R.string.play_movie_label,
                        onClick = { onPlayMovieSelected(movieDetails.id) })
                }
            }
        }

        LaunchedEffect(Unit) {
            playButtonRequester.requestFocus()
        }
    }
}

@DarkBackgroundPreview
@Composable
private fun MovieDetailsContentPreview() {
    MovieDetailsContent(
        isVisible = true,
        movieDetails = MovieDetailsUiModel(
            id = "1",
            title = "The Dark Knight",
            description = "Movie description, some long long text",
            posterUrl = "",
            duration = "1h 22m",
            rating = "9.2/10"
        ),
        onNavigateBackSelected = {},
        onPlayMovieSelected = {}
    )
}
