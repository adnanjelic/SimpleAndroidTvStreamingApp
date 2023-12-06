package com.adnanjelic.simpletvstreamingapp.featurehome.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper.DestinationPresentationToNavigationMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomePresentationDestination
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomePresentationDestination.MovieDetails
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination
import javax.inject.Inject

internal class HomeInfoPresentationDestinationToNavigationDestinationModelMapper @Inject constructor() :
    DestinationPresentationToNavigationMapper<HomePresentationDestination, NavigationDestination> {

    override fun toDestination(input: HomePresentationDestination) = when (input) {
        is MovieDetails -> NavigationDestination.MovieDetails(input.movieId)
    }
}
