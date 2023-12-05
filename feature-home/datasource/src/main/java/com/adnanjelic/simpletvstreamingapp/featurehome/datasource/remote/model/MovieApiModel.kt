package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote.model

import com.adnanjelic.simpletvstreamingapp.architecture.data.model.ApiModel

data class MovieApiModel(
    val id: String,
    val title: String,
    val description: String,
    val posterUrl: String,
    val duration: String,
    val rating: Float,
    val trailerUrl: String
) : ApiModel
