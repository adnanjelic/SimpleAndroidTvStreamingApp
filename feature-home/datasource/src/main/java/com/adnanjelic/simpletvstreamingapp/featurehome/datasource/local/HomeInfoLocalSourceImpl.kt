package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local

import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoLocalSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.HomeInfoDataModel
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.database.SimpleTvStreamingAppDatabase
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.model.CategoryDbModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeInfoLocalSourceImpl(private val database: SimpleTvStreamingAppDatabase) : HomeInfoLocalSource {

    override suspend fun homeInfo(): Flow<HomeInfoDataModel?> {
        return database.categoriesDao().categories().map {
            HomeInfoDataModel(emptyList())
        }
    }

    override suspend fun saveHomeInfo(info: HomeInfoDataModel) {
        database.categoriesDao().saveCategories(emptyList<CategoryDbModel>())
    }
}
