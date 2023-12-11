package com.adnanjelic.simpletvstreamingapp.videoplayerexo.player

import android.content.Context
import android.view.View
import android.widget.ImageButton
import androidx.annotation.OptIn
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.player.VideoPlayer
import com.adnanjelic.simpletvstreamingapp.videoplayerexo.R
import javax.inject.Inject

class VideoPlayerExo @Inject constructor() : VideoPlayer {

    private lateinit var videoPlayer: ExoPlayer

    @OptIn(UnstableApi::class)
    override fun playerView(context: Context, onBackSelected: () -> Unit): View {
        createPlayer(context)
        return PlayerView(context).apply {
            findViewById<ImageButton>(R.id.back_button).setOnClickListener { onBackSelected() }
            setShowPreviousButton(false)
            setShowNextButton(false)
            player = videoPlayer
            requestFocus()
        }
    }

    private fun createPlayer(context: Context) {
        videoPlayer = ExoPlayer
            .Builder(context)
            .build()
    }

    override fun prepareMedia(videoUrl: String) {
        val mediaItem = MediaItem.fromUri(videoUrl)
        videoPlayer.apply {
            setMediaItem(mediaItem)
            playWhenReady = false
            prepare()
        }
    }

    override fun play() {
        videoPlayer.play()
    }

    override fun pause() {
        videoPlayer.pause()
    }

    override fun stop() {
        videoPlayer.stop()
    }

    override fun release() {
        videoPlayer.release()
    }
}
