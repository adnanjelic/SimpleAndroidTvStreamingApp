package com.adnanjelic.simpletvstreamingapp.videoplayer.datasource.local

import com.adnanjelic.simpletvstreamingapp.shared.storage.dao.MoviesLocalSource
import com.adnanjelic.simpletvstreamingapp.videoplayer.datasource.local.mapper.MovieDbToVideoPlayerDataModelMapper
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.data.datasource.VideoPlayerLocalSource
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.data.model.VideoPlayerDataModel

class VideoPlayerLocalSourceImpl(
    private val moviesLocalSource: MoviesLocalSource,
    private val videoPlayerDataMapper: MovieDbToVideoPlayerDataModelMapper
) : VideoPlayerLocalSource {

    override suspend fun videoPlayerData(movieId: String): VideoPlayerDataModel {
        val dbModel = moviesLocalSource.movieDetails(movieId)
        return videoPlayerDataMapper.toData(dbModel)
    }
}
