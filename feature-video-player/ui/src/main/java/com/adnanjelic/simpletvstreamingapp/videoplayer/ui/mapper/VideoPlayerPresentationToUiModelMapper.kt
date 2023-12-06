package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper.PresentationToUiMapper
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerPresentationModel
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.model.VideoPlayerUiModel
import javax.inject.Inject

class VideoPlayerPresentationToUiModelMapper @Inject constructor() :
    PresentationToUiMapper<VideoPlayerPresentationModel, VideoPlayerUiModel> {

    override fun toUi(input: VideoPlayerPresentationModel) = VideoPlayerUiModel(
        videoUrl = input.videoUrl
    )
}
