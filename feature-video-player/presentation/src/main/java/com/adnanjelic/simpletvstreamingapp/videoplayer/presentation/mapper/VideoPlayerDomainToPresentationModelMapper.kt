package com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.mapper.DomainToPresentationMapper
import com.adnanjelic.simpletvstreamingapp.videoplayer.domain.model.VideoPlayerDomainModel
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerPresentationModel
import javax.inject.Inject

class VideoPlayerDomainToPresentationModelMapper @Inject constructor() :
    DomainToPresentationMapper<VideoPlayerDomainModel, VideoPlayerPresentationModel> {

    override fun toPresentation(input: VideoPlayerDomainModel) = VideoPlayerPresentationModel(
        videoUrl = input.videoUrl
    )
}
