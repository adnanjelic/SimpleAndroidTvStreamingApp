package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DbToDataMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.MovieDataModel
import com.adnanjelic.simpletvstreamingapp.shared.database.model.MovieDbModel
import javax.inject.Inject

class MovieDbToDataModelMapper @Inject constructor() :
    DbToDataMapper<MovieDbModel, MovieDataModel> {

    override fun toData(input: MovieDbModel) = MovieDataModel(
        id = input.id,
        title = input.title,
        posterUrl = input.posterUrl,
        description = input.description,
        duration = input.duration,
        rating = input.rating,
        trailerUrl = input.trailerUrl
    )
}
