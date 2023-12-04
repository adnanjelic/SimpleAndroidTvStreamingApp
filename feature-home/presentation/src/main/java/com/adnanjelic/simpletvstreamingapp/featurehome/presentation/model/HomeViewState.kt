package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model

sealed interface HomeViewState {

    data object Initial : HomeViewState

    data class Loaded(val homeInfo: HomeInfoPresentationModel) : HomeViewState
}
