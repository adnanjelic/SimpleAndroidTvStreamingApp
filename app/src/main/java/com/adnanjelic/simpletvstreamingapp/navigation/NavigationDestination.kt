package com.adnanjelic.simpletvstreamingapp.navigation

import com.adnanjelic.simpletvstreamingapp.navigation.NavigationConstants.MovieIdParameter
import com.adnanjelic.simpletvstreamingapp.navigation.NavigationConstants.ParameterWrapper

internal sealed class NavigationDestination(val route: String) {

    data object Home : NavigationDestination("home")

    data object MovieDetails : NavigationDestination("movieDetails".addParameter(MovieIdParameter))

    data object MoviePlayer : NavigationDestination("moviePlayer".addParameter(MovieIdParameter))
}

private fun String.addParameter(parameter: String) = "$this/${ParameterWrapper.format(parameter)}"
