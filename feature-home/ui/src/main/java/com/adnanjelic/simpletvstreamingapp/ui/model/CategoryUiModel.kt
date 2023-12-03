package com.adnanjelic.simpletvstreamingapp.ui.model

internal data class CategoryUiModel(
    val id: String,
    val name: String,
    val items: Collection<MovieUiModel>
)
