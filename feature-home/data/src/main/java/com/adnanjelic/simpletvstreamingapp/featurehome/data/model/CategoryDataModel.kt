package com.adnanjelic.simpletvstreamingapp.featurehome.data.model

import com.adnanjelic.simpletvstreamingapp.architecture.data.model.DataModel

data class CategoryDataModel(
    val id: String,
    val name: String,
    val movies: Collection<MovieDataModel>
) : DataModel
