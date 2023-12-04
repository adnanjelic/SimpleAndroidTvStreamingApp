package com.adnanjelic.simpletvstreamingapp.featurehome.ui.model

import com.adnanjelic.simpletvstreamingapp.architecture.ui.model.UiModel

data class MovieUiModel(
    val id: String,
    val title: String,
    val posterUrl: String
) : UiModel
