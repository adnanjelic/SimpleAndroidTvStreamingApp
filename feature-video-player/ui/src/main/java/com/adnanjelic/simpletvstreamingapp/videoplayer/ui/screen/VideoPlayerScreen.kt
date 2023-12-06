package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.IconButton
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination
import com.adnanjelic.simpletvstreamingapp.theme.Dimension
import com.adnanjelic.simpletvstreamingapp.theme.Green60
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.VideoPlayerViewModel
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerViewState.Loaded
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.R
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.component.VideoPlayer
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.mapper.VideoPlayerPresentationDestinationToNavigationDestinationModelMapper
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.mapper.VideoPlayerPresentationToUiModelMapper

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun VideoPlayerScreen(
    viewModel: VideoPlayerViewModel = hiltViewModel(),
    onNavigation: (NavigationDestination) -> Unit = {}
) {
    val videoInfoMapper = VideoPlayerPresentationToUiModelMapper()
    val destinationMapper = VideoPlayerPresentationDestinationToNavigationDestinationModelMapper()

    val viewState = viewModel.viewState.collectAsStateWithLifecycle()
    val videoInfo = (viewState.value as? Loaded)?.videoInfo?.let {
        videoInfoMapper.toUi(it)
    }
    val navigation = viewModel.navigationDestination.collectAsStateWithLifecycle(null)
    val notification = viewModel.notification.collectAsStateWithLifecycle(null)

    Box(modifier = Modifier.fillMaxSize()) {
        if (videoInfo != null) {
            VideoPlayer(videoUrl = videoInfo.videoUrl)
        }
        IconButton(
            modifier = Modifier.padding(Dimension.Padding.Default),
            onClick = { viewModel.onNavigateBackSelected() },
            colors = ButtonDefaults.colors(focusedContainerColor = Green60)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.back_label)
            )
        }
    }

    navigation.value?.let {
        val destination = destinationMapper.toDestination(it)
        onNavigation(destination)
    }
}
