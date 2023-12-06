package com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.data.datasource

import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.data.model.VideoPlayerDataModel

interface VideoPlayerLocalSource {
    suspend fun videoPlayerData(movieId: String): VideoPlayerDataModel
}
