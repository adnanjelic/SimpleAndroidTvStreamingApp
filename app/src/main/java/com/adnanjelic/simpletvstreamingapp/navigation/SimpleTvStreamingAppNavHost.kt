package com.adnanjelic.simpletvstreamingapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.screen.HomeScreen
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.screen.MovieDetailsScreen
import com.adnanjelic.simpletvstreamingapp.navigation.NavigationConstants.MovieIdParameter

@Composable
fun SimpleTvStreamingAppNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationDestination.Home.route
    ) {
        composable(route = NavigationDestination.Home.route) {
            HomeScreen(onNavigateToMovieDetails = { movieId ->
                navHostController.navigate(
                    NavigationDestination.MovieDetails.route.addParameterValue(
                        parameter = MovieIdParameter,
                        value = movieId
                    )
                )
            })
        }
        composable(
            route = NavigationDestination.MovieDetails.route,
            arguments = listOf(navArgument(MovieIdParameter) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            MovieDetailsScreen(
                navHostController = navHostController,
                movieId = backStackEntry.arguments?.getString(MovieIdParameter)
            )
        }
    }
}
