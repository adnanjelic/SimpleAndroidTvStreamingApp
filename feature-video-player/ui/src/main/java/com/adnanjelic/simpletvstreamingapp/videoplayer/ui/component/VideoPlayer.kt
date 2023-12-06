package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.component

import android.content.Context
import android.widget.ImageButton
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.R

@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(videoUrl: String, onBackSelected: () -> Unit = {}) {
    Column(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current
        val videoPlayer = getPlayer(context, videoUrl)

        val playerView = PlayerView(context).apply {
            findViewById<ImageButton>(R.id.back_button).setOnClickListener { onBackSelected() }
            player = videoPlayer
            requestFocus()
        }

        val lifecycle = remember { mutableStateOf(Lifecycle.Event.ON_CREATE) }
        val lifecycleOwner = LocalLifecycleOwner.current
        DisposableEffect(lifecycleOwner) {
            val observer = LifecycleEventObserver { _, event ->
                lifecycle.value = event
            }
            lifecycleOwner.lifecycle.addObserver(observer)

            onDispose {
                lifecycleOwner.lifecycle.removeObserver(observer)
            }
        }

        AndroidView(
            modifier = Modifier.onKeyEvent { playerView.dispatchKeyEvent(it.nativeKeyEvent) },
            factory = { playerView },
            update = {
                when (lifecycle.value) {
                    Lifecycle.Event.ON_PAUSE -> {
                        playerView.onPause()
                        videoPlayer.pause()
                    }
                    Lifecycle.Event.ON_RESUME -> it.onResume()
                    else -> Unit
                }
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
