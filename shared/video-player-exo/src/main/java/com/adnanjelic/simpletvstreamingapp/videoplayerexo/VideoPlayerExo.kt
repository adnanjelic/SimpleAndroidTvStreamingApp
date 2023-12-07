package com.adnanjelic.simpletvstreamingapp.videoplayerexo

import android.widget.ImageButton
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.ui.PlayerView

@OptIn(UnstableApi::class)
@Composable
fun VideoPlayerExo(
    videoUrl: String,
    onBackSelected: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current
        val mediaItem = MediaItem.fromUri(videoUrl)
        val videoPlayer = remember {
            androidx.media3.exoplayer.ExoPlayer
                .Builder(context)
                .build()
                .apply {
                    setMediaItem(mediaItem)
                    playWhenReady = true
                    prepare()
                }
        }
        val playerView = remember {
            PlayerView(context).apply {
                findViewById<ImageButton>(R.id.back_button).setOnClickListener { onBackSelected() }
                player = videoPlayer
                requestFocus()
            }
        }

        AndroidView(
            modifier = Modifier.onKeyEvent { playerView.dispatchKeyEvent(it.nativeKeyEvent) },
            factory = { playerView },
        )

        DisposableEffect(Unit) {
            onDispose {
                videoPlayer.release()
            }
        }
    }
}
