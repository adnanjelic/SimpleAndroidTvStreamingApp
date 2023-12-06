package com.adnanjelic.simpletvstreamingapp.videoplayer.domain.usecase

import com.adnanjelic.simpletvstreamingapp.architecture.domain.usecase.RunOnceUseCase
import com.adnanjelic.simpletvstreamingapp.videoplayer.domain.model.VideoPlayerDomainModel
import com.adnanjelic.simpletvstreamingapp.videoplayer.domain.repository.VideoPlayerRepository
import javax.inject.Inject

class GetVideoPlayerDataUseCase @Inject constructor(private val repository: VideoPlayerRepository) :
    RunOnceUseCase<String, VideoPlayerDomainModel>() {

    override suspend fun executeInBackground(request: String) = repository.videoPlayerData(request)
}
