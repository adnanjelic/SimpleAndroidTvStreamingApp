package com.adnanjelic.simpletvstreamingapp.featurehome.domain.usecase

import com.adnanjelic.simpletvstreamingapp.architecture.domain.usecase.ContinuousExecutingUseCase
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.model.HomeInfoDomainModel
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.repository.HomeInfoRepository
import javax.inject.Inject

class GetHomeInfoUseCase @Inject constructor(private val homeInfoRepository: HomeInfoRepository) :
    ContinuousExecutingUseCase<Unit, HomeInfoDomainModel>() {

    override suspend fun executeInBackground(request: Unit) = homeInfoRepository.info()
}
