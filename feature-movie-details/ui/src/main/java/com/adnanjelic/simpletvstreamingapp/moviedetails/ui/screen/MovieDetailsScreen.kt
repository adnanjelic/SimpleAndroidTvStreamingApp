package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.MovieDetailsViewModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsViewState
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component.MovieDetailsContent
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.mapper.MovieDetailsPresentationDestinationToNavigationDestinationModelMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.mapper.MovieDetailsPresentationToUiModelMapper
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    movieId: String?,
    viewModel: MovieDetailsViewModel = hiltViewModel(),
    onNavigation: (NavigationDestination) -> Unit = {}
) {
    val movieDetailsMapper = MovieDetailsPresentationToUiModelMapper()
    val destinationMapper = MovieDetailsPresentationDestinationToNavigationDestinationModelMapper()

    val viewState = viewModel.viewState.collectAsStateWithLifecycle()
    val movieDetails = (viewState.value as? MovieDetailsViewState.Loaded)?.movieDetails?.let {
        movieDetailsMapper.toUi(it)
    }
    val navigation = viewModel.navigationDestination.collectAsStateWithLifecycle(null)
    val notification = viewModel.notification.collectAsStateWithLifecycle(null)

    MovieDetailsContent(
        isVisible = movieDetails != null,
        movieDetails = movieDetails,
        onNavigateBackSelected = { viewModel.onNavigateBackSelected() },
        onPlayMovieSelected = { viewModel.onPlayMovieSelected(it)}
    )

    navigation.value?.let {
        val destination = destinationMapper.toDestination(it)
        onNavigation(destination)
    }
}
