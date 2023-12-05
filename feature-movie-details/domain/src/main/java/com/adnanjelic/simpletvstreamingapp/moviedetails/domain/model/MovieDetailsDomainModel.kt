package com.adnanjelic.simpletvstreamingapp.moviedetails.domain.model

import com.adnanjelic.simpletvstreamingapp.architecture.domain.model.DomainModel

data class MovieDetailsDomainModel(
    val id: String,
    val title: String,
    val description: String,
    val posterUrl: String,
    val duration: String,
    val rating: Float
) : DomainModel
