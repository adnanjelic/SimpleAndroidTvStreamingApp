package com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.mapper.DomainToPresentationMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.domain.model.MovieDetailsDomainModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationModel
import javax.inject.Inject

class MovieDetailsDomainToPresentationModelMapper @Inject constructor() :
    DomainToPresentationMapper<MovieDetailsDomainModel, MovieDetailsPresentationModel> {

    override fun toPresentation(input: MovieDetailsDomainModel) = MovieDetailsPresentationModel(
        id = input.id,
        title = input.title,
        description = input.description,
        posterUrl = input.posterUrl,
        duration = input.duration,
        rating = input.rating
    )
}
