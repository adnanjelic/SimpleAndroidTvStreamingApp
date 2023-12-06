package com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.model.PresentationNotification

sealed interface VideoPlayerPresentationNotification : PresentationNotification {

    data class UnknownError(val error: Throwable) : VideoPlayerPresentationNotification
}
