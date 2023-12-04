package com.adnanjelic.simpletvstreamingapp.featurehome.domain.repository

import com.adnanjelic.simpletvstreamingapp.featurehome.domain.model.HomeInfoDomainModel
import kotlinx.coroutines.flow.Flow

interface HomeInfoRepository {

    suspend fun info(): Flow<HomeInfoDomainModel>
}
