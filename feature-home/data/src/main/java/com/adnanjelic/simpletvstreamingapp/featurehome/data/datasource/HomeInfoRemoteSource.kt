package com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource

import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.HomeInfoDataModel

interface HomeInfoRemoteSource {

    suspend fun homeInfo(): HomeInfoDataModel
}
