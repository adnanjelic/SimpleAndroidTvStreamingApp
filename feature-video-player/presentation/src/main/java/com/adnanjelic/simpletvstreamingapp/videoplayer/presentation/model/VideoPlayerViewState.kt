package com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model

sealed interface VideoPlayerViewState {

    data object Loading : VideoPlayerViewState

    data class Loaded(val videoInfo: VideoPlayerPresentationModel) : VideoPlayerViewState
}
