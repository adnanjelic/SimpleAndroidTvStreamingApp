package com.adnanjelic.simpletvstreamingapp.featurehome.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.HomeViewModel
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomeViewState
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.component.HomeContent
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.mapper.CategoryPresentationToUiModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.mapper.HomeInfoPresentationDestinationToNavigationDestinationModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.mapper.MoviePresentationToUiModelMapper
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigation: (NavigationDestination) -> Unit = {}
) {
    val movieMapper = MoviePresentationToUiModelMapper()
    val categoriesMapper = CategoryPresentationToUiModelMapper(movieMapper)
    val destinationMapper = HomeInfoPresentationDestinationToNavigationDestinationModelMapper()

    val viewState = viewModel.viewState.collectAsStateWithLifecycle()
    val categoriesWithMovies =
        (viewState.value as? HomeViewState.Loaded)?.homeInfo?.categories?.map(categoriesMapper::toUi)
    val navigation = viewModel.navigationDestination.collectAsStateWithLifecycle(null)
    val notification = viewModel.notification.collectAsStateWithLifecycle(null)

    HomeContent(
        isVisible = viewState.value is HomeViewState.Loaded,
        categoriesWithMovies = categoriesWithMovies ?: emptyList(),
        onMovieSelected = { viewModel.onMovieSelected(it) }
    )

    navigation.value?.let {
        val destination = destinationMapper.toDestination(it)
        onNavigation(destination)
    }
}

@Preview
@Composable
internal fun HomeScreenPreview() {
    HomeScreen()
}
