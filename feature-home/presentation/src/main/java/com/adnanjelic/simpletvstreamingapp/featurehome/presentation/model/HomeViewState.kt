package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model

internal sealed interface HomeViewState {

    data object Initial : HomeViewState

    data class Loaded(val homeInfo: HomeInfoPresentationModel) : HomeViewState
}
