package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.component

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun VideoPlayer(videoUrl: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current
        val videoPlayer = getPlayer(context, videoUrl)

        AndroidView(
            factory = {
                PlayerView(context).apply { player = videoPlayer }
            }
        )

        DisposableEffect(Unit) {
            onDispose {
                videoPlayer.release()
            }
        }
    }
}

private fun getPlayer(context: Context, videoUrl: String): ExoPlayer {
    val mediaItem = MediaItem.fromUri(videoUrl)
    return ExoPlayer
        .Builder(context)
        .build()
        .apply {
            setMediaItem(mediaItem)
            playWhenReady = true
            prepare()
        }
}
