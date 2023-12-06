package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DbToDataMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.CategoryDataModel
import com.adnanjelic.simpletvstreamingapp.shared.storage.model.CategoryWithMovies
import javax.inject.Inject

class CategoryWithMoviesDbToDataModelMapper @Inject constructor(private val movieMapper: MovieDbToDataModelMapper) :
    DbToDataMapper<CategoryWithMovies, CategoryDataModel> {

    override fun toData(input: CategoryWithMovies) = CategoryDataModel(
        id = input.category.id,
        name = input.category.name,
        items = input.movies.map(movieMapper::toData)
    )
}
