package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model

internal sealed interface HomeViewState {

    data object Initial : HomeViewState

    data class Home(val isLoading: Boolean) : HomeViewState
}
