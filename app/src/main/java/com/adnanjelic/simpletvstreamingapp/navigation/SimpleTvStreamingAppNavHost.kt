package com.adnanjelic.simpletvstreamingapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.screen.HomeScreen
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.screen.MovieDetailsScreen
import com.adnanjelic.simpletvstreamingapp.shared.navigation.NavigationConstants.MovieIdParameter
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination.Back
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination.MovieDetails
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination.MoviePlayer
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.Route
import com.adnanjelic.simpletvstreamingapp.shared.navigation.utils.addParameterValue

@Composable
fun SimpleTvStreamingAppNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Route.Home.route
    ) {
        composable(route = Route.Home.route) {
            HomeScreen(onNavigation = { navHostController.navigate(it) })
        }
        composable(
            route = Route.MovieDetails.route,
            arguments = listOf(navArgument(MovieIdParameter) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            MovieDetailsScreen(
                movieId = backStackEntry.arguments?.getString(MovieIdParameter),
                onNavigation = { navHostController.navigate(it) }
            )
        }
    }
}

private fun NavHostController.navigate(destination: NavigationDestination) {
    when (destination) {
        Back -> popBackStack()
        is MovieDetails -> {
            navigate(
                Route.MovieDetails.route.addParameterValue(
                    parameter = MovieIdParameter,
                    value = destination.movieId
                )
            )
        }
        is MoviePlayer -> {
            /** TODO() **/
        }
    }

}