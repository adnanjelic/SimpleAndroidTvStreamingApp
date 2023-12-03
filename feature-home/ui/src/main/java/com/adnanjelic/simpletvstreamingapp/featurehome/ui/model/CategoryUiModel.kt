package com.adnanjelic.simpletvstreamingapp.featurehome.ui.model

internal data class CategoryUiModel(
    val id: String,
    val name: String,
    val items: Collection<MovieUiModel>
)
