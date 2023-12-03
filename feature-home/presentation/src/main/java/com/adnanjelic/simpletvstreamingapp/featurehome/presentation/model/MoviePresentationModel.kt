package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.model.PresentationModel

data class MoviePresentationModel(
    val id: String,
    val title: String,
    val posterUrl: String
) : PresentationModel
