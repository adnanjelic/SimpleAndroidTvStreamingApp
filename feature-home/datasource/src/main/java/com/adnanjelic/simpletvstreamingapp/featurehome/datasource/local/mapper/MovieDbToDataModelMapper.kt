package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DbToDataMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.MovieDataModel
import javax.inject.Inject

class MovieDbToDataModelMapper @Inject constructor() :
    DbToDataMapper<com.adnanjelic.simpletvstreamingapp.shared.storage.model.MovieDbModel, MovieDataModel> {

    override fun toData(input: com.adnanjelic.simpletvstreamingapp.shared.storage.model.MovieDbModel) = MovieDataModel(
        id = input.id,
        title = input.title,
        posterUrl = input.posterUrl,
        description = input.description,
        duration = input.duration,
        rating = input.rating,
        trailerUrl = input.trailerUrl
    )
}
