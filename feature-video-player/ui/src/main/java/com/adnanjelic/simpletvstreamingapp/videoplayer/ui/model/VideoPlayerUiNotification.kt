package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.model

import com.adnanjelic.simpletvstreamingapp.architecture.ui.model.UiNotification

sealed class VideoPlayerUiNotification(open val message: String) : UiNotification {

    data class ErrorMessage(override val message: String) : VideoPlayerUiNotification(message)
}
