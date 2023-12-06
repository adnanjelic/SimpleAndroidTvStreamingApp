package com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.data.repository

import com.adnanjelic.simpletvstreamingapp.videoplayer.domain.model.VideoPlayerDomainModel
import com.adnanjelic.simpletvstreamingapp.videoplayer.domain.repository.VideoPlayerRepository
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.data.datasource.VideoPlayerLocalSource
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.data.mapper.VideoPlayerDataToDomainModelMapper

class VideoPlayerRepositoryImpl(
    private val localSource: VideoPlayerLocalSource,
    private val videoPlayerMapper: VideoPlayerDataToDomainModelMapper
) : VideoPlayerRepository {

    override suspend fun videoPlayerData(movieId: String): VideoPlayerDomainModel {
        val dataModel = localSource.videoPlayerData(movieId)
        return videoPlayerMapper.toDomain(dataModel)
    }
}
