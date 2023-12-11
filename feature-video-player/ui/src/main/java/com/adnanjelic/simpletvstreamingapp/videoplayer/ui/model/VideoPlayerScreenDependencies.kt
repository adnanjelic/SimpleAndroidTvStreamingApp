package com.adnanjelic.simpletvstreamingapp.videoplayer.ui.model

import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.mapper.VideoPlayerNotificationPresentationToUiModelMapper
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.mapper.VideoPlayerPresentationDestinationToNavigationDestinationModelMapper
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.mapper.VideoPlayerPresentationToUiModelMapper
import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.player.VideoPlayer
import javax.inject.Inject

class VideoPlayerScreenDependencies @Inject constructor(
    val videoInfoMapper: VideoPlayerPresentationToUiModelMapper,
    val destinationMapper: VideoPlayerPresentationDestinationToNavigationDestinationModelMapper,
    val notificationMapper: VideoPlayerNotificationPresentationToUiModelMapper,
    val videoPlayer: VideoPlayer
)
