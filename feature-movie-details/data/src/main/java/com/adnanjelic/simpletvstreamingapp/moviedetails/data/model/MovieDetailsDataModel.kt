package com.adnanjelic.simpletvstreamingapp.moviedetails.data.model

import com.adnanjelic.simpletvstreamingapp.architecture.data.model.DataModel

data class MovieDetailsDataModel(
    val id: String,
    val title: String,
    val description: String,
    val posterUrl: String,
    val duration: String,
    val rating: Float
) : DataModel
