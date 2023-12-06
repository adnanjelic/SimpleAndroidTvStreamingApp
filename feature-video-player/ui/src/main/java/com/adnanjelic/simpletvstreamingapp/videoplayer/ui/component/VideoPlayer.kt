package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.component

import android.content.Context
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(videoUrl: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current
        val videoPlayer = getPlayer(context, videoUrl)
        val playerView = PlayerView(context).apply {
            player = videoPlayer
            requestFocus()
        }

        AndroidView(
            modifier = Modifier.onKeyEvent { playerView.dispatchKeyEvent(it.nativeKeyEvent) },
            factory = { playerView }
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
