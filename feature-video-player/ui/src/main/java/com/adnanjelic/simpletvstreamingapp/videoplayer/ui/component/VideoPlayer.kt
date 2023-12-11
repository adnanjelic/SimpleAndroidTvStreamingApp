package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.component

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle.Event.ON_PAUSE
import androidx.lifecycle.Lifecycle.Event.ON_RESUME
import androidx.lifecycle.Lifecycle.Event.ON_STOP
import androidx.lifecycle.LifecycleEventObserver
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.player.VideoPlayer

@Composable
fun VideoPlayer(
    videoPlayer: VideoPlayer,
    videoUrl: String,
    onBackSelected: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current
        val lifecycleOwner = LocalLifecycleOwner.current

        val playerView = remember {
            videoPlayer.playerView(context, onBackSelected)
        }

        AndroidView(
            modifier = Modifier
                .focusable()
                .onKeyEvent { playerView.dispatchKeyEvent(it.nativeKeyEvent) },
            factory = { playerView },
        )

        LaunchedEffect(Unit) {
            videoPlayer.prepareMedia(videoUrl)
            videoPlayer.play()
        }

        DisposableEffect(lifecycleOwner) {
            val observer = LifecycleEventObserver { _, event ->
                when (event) {
                    ON_RESUME -> {
                        videoPlayer.prepareMedia(videoUrl)
                        videoPlayer.play()
                    }
                    ON_PAUSE -> videoPlayer.pause()
                    ON_STOP -> videoPlayer.stop()
                    else -> {}
                }
            }

            lifecycleOwner.lifecycle.addObserver(observer)

            onDispose {
                lifecycleOwner.lifecycle.removeObserver(observer)
                videoPlayer.release()
            }
        }
    }
}
