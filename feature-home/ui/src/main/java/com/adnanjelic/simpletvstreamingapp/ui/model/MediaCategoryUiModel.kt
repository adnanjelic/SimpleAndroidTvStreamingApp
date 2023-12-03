package com.adnanjelic.simpletvstreamingapp.ui.model

internal data class MediaCategoryUiModel(
    val id: String,
    val name: String,
    val items: Collection<MediaItemUiModel>
)
