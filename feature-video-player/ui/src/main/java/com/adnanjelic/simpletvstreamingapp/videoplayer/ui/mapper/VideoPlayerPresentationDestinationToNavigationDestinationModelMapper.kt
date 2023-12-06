package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper.DestinationPresentationToNavigationMapper
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerPresentationDestination
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerPresentationDestination.Back
import javax.inject.Inject

class VideoPlayerPresentationDestinationToNavigationDestinationModelMapper @Inject constructor() :
    DestinationPresentationToNavigationMapper<VideoPlayerPresentationDestination, NavigationDestination> {

    override fun toDestination(input: VideoPlayerPresentationDestination) = when (input) {
        Back -> NavigationDestination.Back
    }
}
