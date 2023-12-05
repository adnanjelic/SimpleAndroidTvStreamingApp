package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DataToDbMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.CategoryDataModel
import javax.inject.Inject

class CategoryDataToDbModelMapper @Inject constructor(private val movieMapper: MovieDbToDataModelMapper) :
    DataToDbMapper<CategoryDataModel, com.adnanjelic.simpletvstreamingapp.shared.storage.model.CategoryDbModel> {

    override fun toDb(input: CategoryDataModel) =
        com.adnanjelic.simpletvstreamingapp.shared.storage.model.CategoryDbModel(
            id = input.id,
            name = input.name
        )
}
