package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.model.PresentationModel

data class CategoryPresentationModel(
    val id: String,
    val name: String,
    val movies: Collection<MoviePresentationModel>
) : PresentationModel
