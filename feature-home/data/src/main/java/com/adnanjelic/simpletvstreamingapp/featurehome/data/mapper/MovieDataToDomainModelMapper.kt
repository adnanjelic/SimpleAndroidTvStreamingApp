package com.adnanjelic.simpletvstreamingapp.featurehome.data.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DataToDomainMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.MovieDataModel
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.model.MovieDomainModel
import javax.inject.Inject

class MovieDataToDomainModelMapper @Inject constructor() :
    DataToDomainMapper<MovieDataModel, MovieDomainModel> {

    override fun toDomain(input: MovieDataModel) = MovieDomainModel(
        id = input.id,
        title = input.title,
        posterUrl = input.posterUrl
    )
}
