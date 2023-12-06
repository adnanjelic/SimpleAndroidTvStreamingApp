package com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.data.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DataToDomainMapper
import com.adnanjelic.simpletvstreamingapp.videoplayer.domain.model.VideoPlayerDomainModel
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.data.model.VideoPlayerDataModel
import javax.inject.Inject

class VideoPlayerDataToDomainModelMapper @Inject constructor() :
    DataToDomainMapper<VideoPlayerDataModel, VideoPlayerDomainModel> {

    override fun toDomain(input: VideoPlayerDataModel) = VideoPlayerDomainModel(
        videoUrl = input.videoUrl
    )
}
