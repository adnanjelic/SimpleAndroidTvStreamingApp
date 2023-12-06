package com.adnanjelic.simpletvstreamingapp.videoplayer.domain.repository

import com.adnanjelic.simpletvstreamingapp.videoplayer.domain.model.VideoPlayerDomainModel

interface VideoPlayerRepository {
    suspend fun videoPlayerData(movieId: String): VideoPlayerDomainModel
}
