package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper.PresentationToUiMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.model.MovieDetailsUiModel
import javax.inject.Inject

class MovieDetailsPresentationToUiModelMapper @Inject constructor() :
    PresentationToUiMapper<MovieDetailsPresentationModel, MovieDetailsUiModel> {

    override fun toUi(input: MovieDetailsPresentationModel) = MovieDetailsUiModel(
        id = input.id,
        title = input.title,
        posterUrl = input.posterUrl,
        description = input.description,
        duration = input.duration,
        rating = input.rating.toString()
    )
}
