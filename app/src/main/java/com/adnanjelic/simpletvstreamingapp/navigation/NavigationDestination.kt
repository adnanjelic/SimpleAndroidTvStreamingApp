package com.adnanjelic.simpletvstreamingapp.navigation

import com.adnanjelic.simpletvstreamingapp.navigation.NavigationConstants.MovieIdParameter

internal sealed class NavigationDestination(val route: String) {

    data object Home : NavigationDestination("home")

    data object MovieDetails :
        NavigationDestination("movieDetails/{$MovieIdParameter}")

    data object MoviePlayer :
        NavigationDestination("moviePlayer/{$MovieIdParameter}")
}
