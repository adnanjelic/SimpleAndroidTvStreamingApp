package com.adnanjelic.simpletvstreamingapp.featurehome.data.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DataToDomainMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.CategoryDataModel
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.model.CategoryDomainModel
import javax.inject.Inject

class CategoryDataToDomainModelMapper @Inject constructor(
    private val movieMapper: MovieDataToDomainModelMapper
) : DataToDomainMapper<CategoryDataModel, CategoryDomainModel> {

    override fun toDomain(input: CategoryDataModel) = CategoryDomainModel(
        id = input.id,
        name = input.name,
        movies = input.movies.map(movieMapper::toDomain)
    )
}
