package com.adnanjelic.simpletvstreamingapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.di.HomeDependencies
import com.adnanjelic.simpletvstreamingapp.navigation.SimpleTvStreamingAppNavHost
import com.adnanjelic.simpletvstreamingapp.theme.SimpleTvStreamingAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
internal class MainActivity : ComponentActivity() {

    @Inject
    lateinit var homeDependencies: HomeDependencies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleTvStreamingAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    SimpleTvStreamingAppNavHost(
                        navHostController = navController,
                        homeDependencies = homeDependencies
                    )
                }
            }
        }
    }
}
