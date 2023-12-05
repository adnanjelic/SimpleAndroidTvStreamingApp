package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.model

import com.adnanjelic.simpletvstreamingapp.architecture.ui.model.UiModel

data class MovieDetailsUiModel(
    val id: String,
    val title: String,
    val description: String,
    val posterUrl: String,
    val duration: String,
    val rating: String,
) : UiModel
