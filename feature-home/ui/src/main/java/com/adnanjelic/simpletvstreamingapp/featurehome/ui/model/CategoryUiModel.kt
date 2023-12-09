package com.adnanjelic.simpletvstreamingapp.featurehome.ui.model

import com.adnanjelic.simpletvstreamingapp.architecture.ui.model.UiModel

data class CategoryUiModel(
    val id: String,
    val name: String,
    val movies: List<MovieUiModel>
) : UiModel
