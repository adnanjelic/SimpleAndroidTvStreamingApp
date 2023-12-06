package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.screen

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.VideoPlayerViewModel
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerViewState.Loaded
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.component.VideoPlayer
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.model.VideoPlayerScreenDependencies

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun VideoPlayerScreen(
    dependencies: VideoPlayerScreenDependencies,
    viewModel: VideoPlayerViewModel = hiltViewModel(),
    onNavigation: (NavigationDestination) -> Unit = {}
) {
    val viewState = viewModel.viewState.collectAsStateWithLifecycle()
    val videoInfo = (viewState.value as? Loaded)?.videoInfo?.let {
        dependencies.videoInfoMapper.toUi(it)
    }
    val navigation = viewModel.navigationDestination.collectAsStateWithLifecycle(null)
    val notification = viewModel.notification.collectAsStateWithLifecycle(null)

    if (videoInfo != null) {
        VideoPlayer(
            videoUrl = videoInfo.videoUrl,
            onBackSelected = { viewModel.onNavigateBackSelected() }
        )
    }

    navigation.value?.let {
        val destination = dependencies.destinationMapper.toDestination(it)
        onNavigation(destination)
    }

    notification.value?.let {
        val uiNotification = dependencies.notificationMapper.toUi(it)
        val context = LocalContext.current
        LaunchedEffect(key1 = uiNotification) {
            Toast.makeText(context, uiNotification.message, Toast.LENGTH_SHORT).show()
        }
    }
}
