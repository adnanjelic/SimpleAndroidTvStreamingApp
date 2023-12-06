package com.adnanjelic.simpletvstreamingapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.HomeScreenDependencies
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.model.MovieDetailsScreenDependencies
import com.adnanjelic.simpletvstreamingapp.navigation.SimpleTvStreamingAppNavHost
import com.adnanjelic.simpletvstreamingapp.theme.SimpleTvStreamingAppTheme
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.model.VideoPlayerScreenDependencies
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
internal class MainActivity : ComponentActivity() {

    @Inject
    lateinit var homeScreenDependencies: HomeScreenDependencies

    @Inject
    lateinit var movieDetailsScreenDependencies: MovieDetailsScreenDependencies

    @Inject
    lateinit var videoPlayerScreenDependencies: VideoPlayerScreenDependencies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleTvStreamingAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    SimpleTvStreamingAppNavHost(
                        navHostController = navController,
                        homeDependencies = homeScreenDependencies,
                        movieDetailsDependencies = movieDetailsScreenDependencies,
                        videoPlayerScreenDependencies = videoPlayerScreenDependencies
                    )
                }
            }
        }
    }
}
