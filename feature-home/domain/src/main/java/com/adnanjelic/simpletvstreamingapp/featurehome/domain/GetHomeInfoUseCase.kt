package com.adnanjelic.simpletvstreamingapp.featurehome.domain

import com.adnanjelic.simpletvstreamingapp.architecture.domain.CoroutineContextProvider
import com.adnanjelic.simpletvstreamingapp.architecture.domain.usecase.ContinuousExecutingUseCase
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.model.HomeInfoDomainModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHomeInfoUseCase @Inject constructor(coroutineContextProvider: CoroutineContextProvider) :
    ContinuousExecutingUseCase<Unit, HomeInfoDomainModel>(coroutineContextProvider) {

    override suspend fun executeInBackground(request: Unit): Flow<HomeInfoDomainModel> {
        TODO("Not yet implemented")
    }
}
