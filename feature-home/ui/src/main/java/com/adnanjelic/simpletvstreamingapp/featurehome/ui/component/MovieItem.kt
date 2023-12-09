package com.adnanjelic.simpletvstreamingapp.featurehome.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import coil.compose.AsyncImage
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.component.stub.MovieStub2
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.MovieUiModel
import com.adnanjelic.simpletvstreamingapp.theme.Dimension.Padding.Small

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
internal fun MovieItem(
    movie: MovieUiModel,
    focusRequester: FocusRequester,
    onMovieFocused: (String) -> Unit,
    onMovieSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier.size(100.dp, 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier
                .weight(1.6f)
                .focusRequester(focusRequester)
                .onFocusChanged { if (it.hasFocus) onMovieFocused(movie.id) },
            onClick = { onMovieSelected(movie.id) }
        ) {
            AsyncImage(
                model = movie.posterUrl,
                modifier = Modifier.fillMaxSize(),
                contentDescription = movie.title,
                contentScale = ContentScale.Crop
            )
        }

        Text(
            modifier = Modifier
                .padding(top = Small)
                .weight(0.4f),
            text = movie.title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
private fun MovieItemPreview() {
    MovieItem(MovieStub2, FocusRequester(), {}, {})
}
