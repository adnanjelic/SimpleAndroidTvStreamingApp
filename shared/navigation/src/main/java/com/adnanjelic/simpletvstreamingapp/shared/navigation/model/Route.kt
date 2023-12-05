package com.adnanjelic.simpletvstreamingapp.shared.navigation.model

import com.adnanjelic.simpletvstreamingapp.shared.navigation.NavigationConstants.MOVIE_ID_PARAMETER
import com.adnanjelic.simpletvstreamingapp.shared.navigation.utils.addParameter

sealed class Route(val route: String) {

    data object Home : Route("home")

    data object MovieDetails : Route("movieDetails".addParameter(MOVIE_ID_PARAMETER))

    data object MoviePlayer : Route("moviePlayer".addParameter(MOVIE_ID_PARAMETER))
}
