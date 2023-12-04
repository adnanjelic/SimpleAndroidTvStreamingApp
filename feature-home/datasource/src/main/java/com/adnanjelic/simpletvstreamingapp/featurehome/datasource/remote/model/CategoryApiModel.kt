package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote.model

import com.adnanjelic.simpletvstreamingapp.architecture.data.model.ApiModel

data class CategoryApiModel(
    val id: String,
    val name: String,
    val movies: Collection<MovieApiModel>
) : ApiModel
