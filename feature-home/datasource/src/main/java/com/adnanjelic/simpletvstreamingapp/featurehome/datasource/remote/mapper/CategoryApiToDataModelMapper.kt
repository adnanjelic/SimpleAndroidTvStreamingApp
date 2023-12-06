package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.ApiToDataMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.CategoryDataModel
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote.model.CategoryApiModel
import javax.inject.Inject

class CategoryApiToDataModelMapper @Inject constructor(private val movieMapper: MovieApiToDataModelMapper) :
    ApiToDataMapper<CategoryApiModel, CategoryDataModel> {

    override fun toData(input: CategoryApiModel) = CategoryDataModel(
        id = input.id,
        name = input.name,
        movies = input.movies.map(movieMapper::toData)
    )
}
