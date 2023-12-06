package com.adnanjelic.simpletvstreamingapp.featurehome.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper.PresentationToUiMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.CategoryPresentationModel
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.CategoryUiModel
import javax.inject.Inject

internal class CategoryPresentationToUiModelMapper @Inject constructor(private val movieMapper: MoviePresentationToUiModelMapper) :
    PresentationToUiMapper<CategoryPresentationModel, CategoryUiModel> {

    override fun toUi(input: CategoryPresentationModel) = CategoryUiModel(
        id = input.id,
        name = input.name,
        movies = input.movies.map(movieMapper::toUi)
    )
}
