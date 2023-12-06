package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.screen

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.MovieDetailsViewModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsViewState.Loaded
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component.MovieDetailsContent
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.mapper.MovieDetailsNotificationPresentationToUiModelMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.mapper.MovieDetailsPresentationDestinationToNavigationDestinationModelMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.mapper.MovieDetailsPresentationToUiModelMapper
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination

@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel = hiltViewModel(),
    onNavigation: (NavigationDestination) -> Unit = {}
) {
    val movieDetailsMapper = MovieDetailsPresentationToUiModelMapper()
    val destinationMapper = MovieDetailsPresentationDestinationToNavigationDestinationModelMapper()
    val notificationMapper = MovieDetailsNotificationPresentationToUiModelMapper()

    val viewState = viewModel.viewState.collectAsStateWithLifecycle()
    val movieDetails = (viewState.value as? Loaded)?.movieDetails?.let {
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

    notification.value?.let {
        val uiNotification = notificationMapper.toUi(it)
        val context = LocalContext.current
        LaunchedEffect(key1 = uiNotification) {
            Toast.makeText(context, uiNotification.message, Toast.LENGTH_SHORT).show()
        }
    }
}
