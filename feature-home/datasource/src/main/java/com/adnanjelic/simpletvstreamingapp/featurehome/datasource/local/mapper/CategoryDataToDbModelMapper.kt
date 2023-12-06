package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DataToDbMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.CategoryDataModel
import com.adnanjelic.simpletvstreamingapp.shared.storage.model.CategoryDbModel
import javax.inject.Inject

class CategoryDataToDbModelMapper @Inject constructor() :
    DataToDbMapper<CategoryDataModel, CategoryDbModel> {

    override fun toDb(input: CategoryDataModel) =
        CategoryDbModel(
            id = input.id,
            name = input.name
        )
}
