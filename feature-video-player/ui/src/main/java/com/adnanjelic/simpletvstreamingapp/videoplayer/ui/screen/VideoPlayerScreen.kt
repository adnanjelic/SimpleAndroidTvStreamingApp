package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination
import com.adnanjelic.simpletvstreamingapp.shared.ui.component.Notification
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.VideoPlayerViewModel
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerViewState.Loaded
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.component.VideoPlayer
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.model.VideoPlayerScreenDependencies

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
            videoPlayer = dependencies.videoPlayer,
            videoUrl = videoInfo.videoUrl
        ) { viewModel.onNavigateBackSelected() }
    }

    navigation.value?.let {
        val destination = dependencies.destinationMapper.toDestination(it)
        onNavigation(destination)
    }

    notification.value?.let {
        val uiNotification = dependencies.notificationMapper.toUi(it)
        Notification(message = uiNotification.message)
    }
}
