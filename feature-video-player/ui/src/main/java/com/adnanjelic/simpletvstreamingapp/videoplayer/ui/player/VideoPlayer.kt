package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.player

import android.content.Context
import android.view.View

interface VideoPlayer {

    fun playerView(context: Context, onBackSelected: () -> Unit = {}): View
    fun prepareMedia(videoUrl: String)
    fun play()
    fun pause()
    fun stop()
    fun release()
}
