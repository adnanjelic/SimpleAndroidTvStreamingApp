package com.adnanjelic.simpletvstreamingapp.featurehome.ui.model

import com.adnanjelic.simpletvstreamingapp.architecture.ui.model.UiModel

internal data class CategoryUiModel(
    val id: String,
    val name: String,
    val movies: Collection<MovieUiModel>
) : UiModel
