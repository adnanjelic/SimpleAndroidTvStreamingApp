package com.adnanjelic.simpletvstreamingapp.featurehome.data.repository

import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoLocalSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoRemoteSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.mapper.HomeInfoDataToDomainMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.model.HomeInfoDomainModel
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.repository.HomeInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

class HomeInfoRepositoryImpl(
    private val localSource: HomeInfoLocalSource,
    private val remoteSource: HomeInfoRemoteSource,
    private val mapper: HomeInfoDataToDomainMapper
) : HomeInfoRepository {

    override suspend fun info(): Flow<HomeInfoDomainModel> {
        return localSource.homeInfo()
            .map { cachedData ->
                if (cachedData == null) {
                    val freshData = remoteSource.homeInfo()
                    localSource.saveHomeInfo(freshData)
                    mapper.toDomain(freshData)
                } else {
                    mapper.toDomain(cachedData)
                }
            }
            .distinctUntilChanged()
    }
}
