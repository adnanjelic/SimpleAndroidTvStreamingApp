package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.mapper.DomainToPresentationMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.model.MovieDomainModel
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.MoviePresentationModel
import javax.inject.Inject

class MovieDomainToPresentationModelMapper @Inject constructor() :
    DomainToPresentationMapper<MovieDomainModel, MoviePresentationModel> {

    override fun toPresentation(input: MovieDomainModel) = MoviePresentationModel(
        id = input.id,
        title = input.title,
        posterUrl = input.posterUrl
    )
}
