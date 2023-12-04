package com.adnanjelic.simpletvstreamingapp.featurehome.data.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DataToDomainMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.HomeInfoDataModel
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.model.HomeInfoDomainModel
import javax.inject.Inject

class HomeInfoDataToDomainMapper @Inject constructor(
    private val categoryMapper: CategoryDataToDomainModelMapper
) : DataToDomainMapper<HomeInfoDataModel, HomeInfoDomainModel> {

    override fun toDomain(input: HomeInfoDataModel) =
        HomeInfoDomainModel(categories = input.categories.map(categoryMapper::toDomain))
}
