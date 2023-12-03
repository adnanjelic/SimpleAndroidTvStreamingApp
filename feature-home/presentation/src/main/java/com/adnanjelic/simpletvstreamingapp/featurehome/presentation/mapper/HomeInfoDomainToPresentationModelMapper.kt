package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.mapper.DomainToPresentationMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.model.HomeInfoDomainModel
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomeInfoPresentationModel
import javax.inject.Inject

class HomeInfoDomainToPresentationModelMapper @Inject constructor(
    private val categoryMapper: CategoryDomainToPresentationModelMapper
) : DomainToPresentationMapper<HomeInfoDomainModel, HomeInfoPresentationModel> {

    override fun toPresentation(input: HomeInfoDomainModel): HomeInfoPresentationModel =
        HomeInfoPresentationModel(categories = input.categories.map(categoryMapper::toPresentation))
}
