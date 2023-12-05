package com.adnanjelic.simpletvstreamingapp.moviedetails.data.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DataToDomainMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.data.model.MovieDetailsDataModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.domain.model.MovieDetailsDomainModel
import javax.inject.Inject

class MovieDetailsDataToDomainModelMapper @Inject constructor() :
    DataToDomainMapper<MovieDetailsDataModel, MovieDetailsDomainModel> {

    override fun toDomain(input: MovieDetailsDataModel) = MovieDetailsDomainModel(
        id = input.id,
        title = input.title,
        description = input.description,
        posterUrl = input.posterUrl,
        duration = input.duration,
        rating = input.rating
    )
}
