package com.adnanjelic.simpletvstreamingapp.featurehome.domain.model

import com.adnanjelic.simpletvstreamingapp.architecture.domain.model.DomainModel

data class MovieDomainModel(
    val id: String,
    val title: String,
    val posterUrl: String
) : DomainModel
