package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local

import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoLocalSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.HomeInfoDataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class HomeInfoLocalSourceImpl : HomeInfoLocalSource {

    override suspend fun homeInfo(): Flow<HomeInfoDataModel?> {
        return flowOf(HomeInfoDataModel(emptyList()))
    }

    override suspend fun saveHomeInfo(info: HomeInfoDataModel) {

    }
}
