package com.adnanjelic.simpletvstreamingapp.featurehome.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper.PresentationToUiMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.MoviePresentationModel
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.MovieUiModel
import javax.inject.Inject

internal class MoviePresentationToUiModelMapper @Inject constructor() :
    PresentationToUiMapper<MoviePresentationModel, MovieUiModel> {

    override fun toUi(input: MoviePresentationModel) = MovieUiModel(
        id = input.id,
        title = input.title,
        posterUrl = input.posterUrl
    )
}
