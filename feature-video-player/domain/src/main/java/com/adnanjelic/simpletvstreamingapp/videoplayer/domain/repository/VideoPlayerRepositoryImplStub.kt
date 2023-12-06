package com.adnanjelic.simpletvstreamingapp.videoplayer.domain.repository

import com.adnanjelic.simpletvstreamingapp.videoplayer.domain.model.VideoPlayerDomainModel

class VideoPlayerRepositoryImplStub : VideoPlayerRepository {

    override suspend fun videoPlayerData(movieId: String): VideoPlayerDomainModel {
        return VideoPlayerDomainModel("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
    }
}
