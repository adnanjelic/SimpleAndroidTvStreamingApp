package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote

import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoRemoteSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.HomeInfoDataModel

class HomeInfoRemoteSourceImpl : HomeInfoRemoteSource {

    override suspend fun homeInfo(): HomeInfoDataModel {
        return HomeInfoDataModel(emptyList())
    }
}
