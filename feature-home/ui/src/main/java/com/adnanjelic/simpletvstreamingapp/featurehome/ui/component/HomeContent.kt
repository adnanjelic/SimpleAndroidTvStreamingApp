package com.adnanjelic.simpletvstreamingapp.featurehome.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.tv.foundation.lazy.list.TvLazyColumn
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.CategoryUiModel
import com.adnanjelic.simpletvstreamingapp.theme.Dimension

@Composable
internal fun HomeContent(
    isVisible: Boolean,
    categoriesWithMovies: Collection<CategoryUiModel>,
    onMovieSelected: (String) -> Unit = {}
) {
    AnimatedVisibility(visible = isVisible) {
        val focusRequesters = remember { mutableMapOf<String, FocusRequester>() }
        var lastFocusedMovieId by rememberSaveable { mutableStateOf("") }

        TvLazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = Dimension.Padding.Big)
        ) {
            categoriesWithMovies.forEach { category ->
                item(key = category.id) {
                    CategoryWithMovies(
                        category = category,
                        onMovieFocused = { lastFocusedMovieId = it },
                        onMovieSelected = onMovieSelected,
                        focusRequesters = focusRequesters
                    )
                }
            }
        }

        LaunchedEffect(Unit) {
            focusOnLastFocusedOrFirstMovie(
                lastFocusedMovie = lastFocusedMovieId,
                categoriesWithMovies = categoriesWithMovies,
                focusRequesters = focusRequesters
            )
        }
    }
}

private fun focusOnLastFocusedOrFirstMovie(
    lastFocusedMovie: String,
    categoriesWithMovies: Collection<CategoryUiModel>,
    focusRequesters: Map<String, FocusRequester>
) {
    val movieToFocusOn = focusRequesters[lastFocusedMovie]
        ?: focusRequesters[categoriesWithMovies.firstOrNull()?.movies?.firstOrNull()?.id]
    movieToFocusOn?.requestFocus()
}

