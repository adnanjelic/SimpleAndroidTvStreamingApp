package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.mapper.DomainToPresentationMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.model.CategoryDomainModel
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.CategoryPresentationModel
import javax.inject.Inject

class CategoryDomainToPresentationModelMapper @Inject constructor(
    private val movieMapper: MovieDomainToPresentationModelMapper
) : DomainToPresentationMapper<CategoryDomainModel, CategoryPresentationModel> {

    override fun toPresentation(input: CategoryDomainModel) = CategoryPresentationModel(
        id = input.id,
        name = input.name,
        movies = input.movies.map(movieMapper::toPresentation)
    )
}
