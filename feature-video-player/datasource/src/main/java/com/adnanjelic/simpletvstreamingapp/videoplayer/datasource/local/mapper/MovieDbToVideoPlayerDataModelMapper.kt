package com.adnanjelic.simpletvstreamingapp.videoplayer.datasource.local.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DbToDataMapper
import com.adnanjelic.simpletvstreamingapp.shared.storage.model.MovieDbModel
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.data.model.VideoPlayerDataModel
import javax.inject.Inject

class MovieDbToVideoPlayerDataModelMapper @Inject constructor() :
    DbToDataMapper<MovieDbModel, VideoPlayerDataModel> {

    override fun toData(input: MovieDbModel) = VideoPlayerDataModel(videoUrl = input.trailerUrl)
}
