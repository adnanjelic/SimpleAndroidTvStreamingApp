package com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.model.PresentationModel

data class MovieDetailsPresentationModel(
    val id: String,
    val title: String,
    val description: String,
    val posterUrl: String,
    val duration: String,
    val rating: Float
) : PresentationModel
