package com.adnanjelic.simpletvstreamingapp.shared.navigation.model

sealed interface NavigationDestination {

    data object Back : NavigationDestination

    data class MovieDetails(val movieId: String) : NavigationDestination

    data class MoviePlayer(val movieId: String) : NavigationDestination
}
