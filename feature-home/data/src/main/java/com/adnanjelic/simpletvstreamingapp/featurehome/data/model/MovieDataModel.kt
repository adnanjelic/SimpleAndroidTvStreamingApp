package com.adnanjelic.simpletvstreamingapp.featurehome.data.model

import com.adnanjelic.simpletvstreamingapp.architecture.data.model.DataModel

data class MovieDataModel(
    val id: String,
    val title: String,
    val description: String,
    val posterUrl: String,
    val duration: String,
    val rating: Float,
    val trailerUrl: String
) : DataModel
