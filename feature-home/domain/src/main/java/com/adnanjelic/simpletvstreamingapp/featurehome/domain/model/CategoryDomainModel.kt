package com.adnanjelic.simpletvstreamingapp.featurehome.domain.model

import com.adnanjelic.simpletvstreamingapp.architecture.domain.model.DomainModel

data class CategoryDomainModel(
    val id: String,
    val name: String,
    val movies: Collection<MovieDomainModel>
) : DomainModel
