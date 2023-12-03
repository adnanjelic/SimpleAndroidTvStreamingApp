package com.adnanjelic.simpletvstreamingapp.featurehome.domain.model

import com.adnanjelic.simpletvstreamingapp.architecture.domain.model.DomainModel

data class HomeInfoDomainModel(val categories: Collection<CategoryDomainModel>) : DomainModel
