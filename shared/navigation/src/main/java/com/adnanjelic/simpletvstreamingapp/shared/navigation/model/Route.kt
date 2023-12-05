package com.adnanjelic.simpletvstreamingapp.shared.navigation.model

import com.adnanjelic.simpletvstreamingapp.shared.navigation.NavigationConstants.MovieIdParameter
import com.adnanjelic.simpletvstreamingapp.shared.navigation.utils.addParameter

sealed class Route(val route: String) {

    data object Home : Route("home")

    data object MovieDetails : Route("movieDetails".addParameter(MovieIdParameter))

    data object MoviePlayer : Route("moviePlayer".addParameter(MovieIdParameter))
}
