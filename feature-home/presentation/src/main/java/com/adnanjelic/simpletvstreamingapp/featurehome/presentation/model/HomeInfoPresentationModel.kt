package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.model.PresentationModel

data class HomeInfoPresentationModel(val categories: Collection<CategoryPresentationModel>) :
    PresentationModel
