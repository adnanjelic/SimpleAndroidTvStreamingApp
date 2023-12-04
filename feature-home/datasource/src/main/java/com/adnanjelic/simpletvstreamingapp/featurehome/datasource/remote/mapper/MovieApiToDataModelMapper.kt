package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.ApiToDataMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.MovieDataModel
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote.model.MovieApiModel
import javax.inject.Inject

class MovieApiToDataModelMapper @Inject constructor() :
    ApiToDataMapper<MovieApiModel, MovieDataModel> {

    override fun toData(input: MovieApiModel) = MovieDataModel(
        id = input.id,
        title = input.title,
        posterUrl = input.posterUrl
    )
}
