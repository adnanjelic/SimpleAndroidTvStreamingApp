package com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.navigation.PresentationDestination

sealed interface MovieDetailsPresentationDestination : PresentationDestination {

    data object Back : MovieDetailsPresentationDestination

    data class PlayMovie(val movieId: String) : MovieDetailsPresentationDestination
}
