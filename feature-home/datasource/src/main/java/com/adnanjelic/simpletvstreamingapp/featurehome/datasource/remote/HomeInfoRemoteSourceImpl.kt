package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote

import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoRemoteSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.HomeInfoDataModel
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote.mapper.CategoryApiToDataModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote.model.stubCategoryApiModels
import kotlinx.coroutines.delay

class HomeInfoRemoteSourceImpl(private val categoryMapper: CategoryApiToDataModelMapper) :
    HomeInfoRemoteSource {

    override suspend fun homeInfo(): HomeInfoDataModel {
        delay(3000) // simulate some network delay
        val categoryDataModels = stubCategoryApiModels().map(categoryMapper::toData)
        return HomeInfoDataModel(categories = categoryDataModels)
    }
}
