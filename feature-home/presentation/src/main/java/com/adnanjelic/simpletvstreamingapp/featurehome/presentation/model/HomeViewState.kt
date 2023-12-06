package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model

sealed interface HomeViewState {

    data object Loading : HomeViewState

    data class Loaded(val homeInfo: HomeInfoPresentationModel) : HomeViewState
}
