package com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.model.PresentationDestination

sealed interface VideoPlayerPresentationDestination : PresentationDestination {

    data object Back : VideoPlayerPresentationDestination
}
