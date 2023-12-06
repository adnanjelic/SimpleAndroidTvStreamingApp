package com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model

sealed interface MovieDetailsViewState {

    data object Empty : MovieDetailsViewState

    data class Loaded(val movieDetails: MovieDetailsPresentationModel) : MovieDetailsViewState
}
