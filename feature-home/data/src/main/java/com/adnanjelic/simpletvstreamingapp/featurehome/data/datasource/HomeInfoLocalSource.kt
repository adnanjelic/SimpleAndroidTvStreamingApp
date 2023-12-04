package com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource

import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.HomeInfoDataModel
import kotlinx.coroutines.flow.Flow

interface HomeInfoLocalSource {

    suspend fun homeInfo(): Flow<HomeInfoDataModel?>

    suspend fun saveHomeInfo(info: HomeInfoDataModel)
}
