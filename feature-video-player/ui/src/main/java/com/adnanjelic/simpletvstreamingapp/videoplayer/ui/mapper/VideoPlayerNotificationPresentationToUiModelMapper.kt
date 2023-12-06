package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper.PresentationToUiNotificationMapper
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerPresentationNotification
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerPresentationNotification.UnknownError
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.model.VideoPlayerUiNotification
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.model.VideoPlayerUiNotification.ErrorMessage
import javax.inject.Inject

class VideoPlayerNotificationPresentationToUiModelMapper @Inject constructor() :
    PresentationToUiNotificationMapper<VideoPlayerPresentationNotification, VideoPlayerUiNotification> {

    override fun toUi(input: VideoPlayerPresentationNotification) = when (input) {
        is UnknownError -> ErrorMessage("Unknown error occurred, please try later") // TODO: Add string to resources
    }
}
