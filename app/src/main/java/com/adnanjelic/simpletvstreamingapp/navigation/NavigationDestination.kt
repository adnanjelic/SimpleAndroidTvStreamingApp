package com.adnanjelic.simpletvstreamingapp.navigation

import com.adnanjelic.simpletvstreamingapp.navigation.NavigationConstants.MovieIdParameter

internal sealed class NavigationDestination(val route: String) {

    data object Home : NavigationDestination("home")

    data object MovieDetails : NavigationDestination("movieDetails".addParameter(MovieIdParameter))

    data object MoviePlayer : NavigationDestination("moviePlayer".addParameter(MovieIdParameter))
}
