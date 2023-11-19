package com.adnanjelic.ui.model

data class MediaCategoryUiModel(
    val id: String,
    val name: String,
    val items: Collection<MediaItemUiModel>
)
