package com.adnanjelic.simpletvstreamingapp.featurehome.ui.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.HomeViewModel
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomeViewState
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.component.HomeContent
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.component.ProgressIndicator
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.HomeScreenDependencies
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination
import com.adnanjelic.simpletvstreamingapp.shared.ui.component.Notification

@Composable
fun HomeScreen(
    dependencies: HomeScreenDependencies,
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigation: (NavigationDestination) -> Unit = {}
) {
    val viewState = viewModel.viewState.collectAsStateWithLifecycle()
    val categoriesWithMovies =
        (viewState.value as? HomeViewState.Loaded)?.homeInfo?.categories?.map(dependencies.categoriesMapper::toUi)
    val navigation = viewModel.navigationDestination.collectAsStateWithLifecycle(null)
    val notification = viewModel.notification.collectAsStateWithLifecycle(null)

    ProgressIndicator(isVisible = viewState.value == HomeViewState.Loading)

    HomeContent(
        isVisible = viewState.value is HomeViewState.Loaded,
        categoriesWithMovies = categoriesWithMovies ?: emptyList(),
        onMovieSelected = { viewModel.onMovieSelected(it) }
    )

    navigation.value?.let {
        val destination = dependencies.destinationMapper.toDestination(it)
        onNavigation(destination)
    }

    notification.value?.let {
        val uiNotification = dependencies.notificationMapper.toUi(it)
        Notification(uiNotification.message)
    }
}
