package com.adnanjelic.simpletvstreamingapp.featurehome.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.component.stub.CategoryStub1
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.CategoryUiModel
import com.adnanjelic.simpletvstreamingapp.theme.Dimension.Padding.Default
import com.adnanjelic.simpletvstreamingapp.theme.Dimension.Padding.Small

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
internal fun CategoryWithMoviesRow(
    category: CategoryUiModel,
    onMovieFocused: (String) -> Unit,
    onMovieSelected: (String) -> Unit,
    focusRequesters: MutableMap<String, FocusRequester>,
) {
    Text(
        text = category.name,
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.padding(bottom = Small, start = Default)
    )

    TvLazyRow {
        category.movies.forEach { movie ->
            item(key = movie.id) {
                val focusRequester = remember { FocusRequester() }
                focusRequesters[movie.id] = focusRequester

                Spacer(modifier = Modifier.size(Default))

                Column(
                    modifier = Modifier.size(100.dp, 200.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MovieCard(
                        modifier = Modifier
                            .focusRequester(focusRequester)
                            .onFocusChanged { if (it.hasFocus) onMovieFocused(movie.id) },
                        movie = movie,
                        onMovieSelected = onMovieSelected
                    )
                    Text(
                        modifier = Modifier.padding(top = Small),
                        text = movie.title,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodySmall,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CategoryWithMoviesRowPreview() {
    CategoryWithMoviesRow(CategoryStub1, {}, {}, mutableMapOf())
}
