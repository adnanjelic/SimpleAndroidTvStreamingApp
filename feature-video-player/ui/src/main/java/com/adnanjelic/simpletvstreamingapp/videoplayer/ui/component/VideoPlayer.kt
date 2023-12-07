package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.component

import androidx.compose.runtime.Composable
import com.adnanjelic.simpletvstreamingapp.videoplayerexo.VideoPlayerExo

@Composable
fun VideoPlayer(
    videoUrl: String,
    onBackSelected: () -> Unit = {}
) {
    VideoPlayerExo(
        videoUrl = videoUrl,
        onBackSelected = onBackSelected
    )
}
