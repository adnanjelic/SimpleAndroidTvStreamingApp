package com.adnanjelic.simpletvstreamingapp.presentation.model

internal sealed interface HomeViewState {

    data object Initial : HomeViewState

    data class Home(val isLoading: Boolean) : HomeViewState
}
