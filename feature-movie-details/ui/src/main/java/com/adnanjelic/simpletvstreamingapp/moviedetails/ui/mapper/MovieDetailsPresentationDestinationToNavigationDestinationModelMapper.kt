package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper.DestinationPresentationToNavigationMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationDestination
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationDestination.Back
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationDestination.PlayMovie
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination
import javax.inject.Inject

class MovieDetailsPresentationDestinationToNavigationDestinationModelMapper @Inject constructor() :
    DestinationPresentationToNavigationMapper<MovieDetailsPresentationDestination, NavigationDestination> {

    override fun toDestination(input: MovieDetailsPresentationDestination) = when (input) {
        Back -> NavigationDestination.Back
        is PlayMovie -> NavigationDestination.MoviePlayer(input.movieId)
    }
}
