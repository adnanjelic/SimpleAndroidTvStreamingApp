package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.MovieDetailsViewModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsViewState
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component.MovieDetailsContent
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.mapper.MovieDetailsPresentationToUiModelMapper

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    movieId: String?,
    viewModel: MovieDetailsViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit = {},
    onPlayMovie: (String) -> Unit = {}
) {
    val movieDetailsMapper = MovieDetailsPresentationToUiModelMapper()

    val viewState = viewModel.viewState.collectAsStateWithLifecycle()
    val movieDetails = (viewState.value as? MovieDetailsViewState.Loaded)?.movieDetails?.let {
        movieDetailsMapper.toUi(it)
    }
    val navigation = viewModel.navigationDestination.collectAsStateWithLifecycle(null)
    val notification = viewModel.notification.collectAsStateWithLifecycle(null)

    Text("MovieDetailsScreen, movieId: $movieId", color = Color.White)

    MovieDetailsContent(
        isVisible = movieDetails != null,
        movieDetails = movieDetails,
        onNavigateBackSelected = { viewModel.onNavigateBackSelected() },
        onPlayMovieSelected = { viewModel.onPlayMovieSelected(it)}
    )
}
