package com.adnanjelic.simpletvstreamingapp.moviedetails.datasource.local.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DbToDataMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.data.model.MovieDetailsDataModel
import javax.inject.Inject

class MovieDetailsDbToDataModelMapper @Inject constructor() :
    DbToDataMapper<com.adnanjelic.simpletvstreamingapp.shared.storage.model.MovieDbModel, MovieDetailsDataModel> {

    override fun toData(input: com.adnanjelic.simpletvstreamingapp.shared.storage.model.MovieDbModel) = MovieDetailsDataModel(
        id = input.id,
        title = input.title,
        posterUrl = input.posterUrl,
        description = input.description,
        duration = input.duration,
        rating = input.rating
    )
}
