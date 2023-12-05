package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.navigation.PresentationDestination

sealed interface HomePresentationDestination : PresentationDestination {

    data class MovieDetails(val movieId: String) : HomePresentationDestination
}
