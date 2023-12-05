package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DbToDataMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.CategoryDataModel
import javax.inject.Inject

class CategoryWithMoviesDbToDataModelMapper @Inject constructor(private val movieMapper: MovieDbToDataModelMapper) :
    DbToDataMapper<com.adnanjelic.simpletvstreamingapp.shared.storage.model.CategoryWithMovies, CategoryDataModel> {

    override fun toData(input: com.adnanjelic.simpletvstreamingapp.shared.storage.model.CategoryWithMovies) = CategoryDataModel(
        id = input.category.id,
        name = input.category.name,
        items = input.movies.map(movieMapper::toData)
    )
}
