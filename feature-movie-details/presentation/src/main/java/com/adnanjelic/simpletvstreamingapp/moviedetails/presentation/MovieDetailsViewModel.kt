package com.adnanjelic.simpletvstreamingapp.moviedetails.presentation

import androidx.lifecycle.SavedStateHandle
import com.adnanjelic.simpletvstreamingapp.architecture.domain.UseCaseExecutor
import com.adnanjelic.simpletvstreamingapp.architecture.presentation.viewmodel.BaseViewModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.domain.usecase.GetMovieDetailsUseCase
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.mapper.MovieDetailsDomainToPresentationExceptionMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.mapper.MovieDetailsDomainToPresentationModelMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationDestination
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationDestination.Back
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationDestination.PlayMovie
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationNotification
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsViewState
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsViewState.Loaded
import com.adnanjelic.simpletvstreamingapp.shared.navigation.NavigationConstants.MOVIE_ID_PARAMETER
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val movieDetailsMapper: MovieDetailsDomainToPresentationModelMapper,
    private val exceptionMapper: MovieDetailsDomainToPresentationExceptionMapper,
    savedStateHandle: SavedStateHandle,
    useCaseExecutor: UseCaseExecutor
) : BaseViewModel<MovieDetailsViewState, MovieDetailsPresentationNotification, MovieDetailsPresentationDestination>(
    useCaseExecutor
) {
    override val initialViewState = MovieDetailsViewState.Initial

    private val movieId: String = checkNotNull(savedStateHandle[MOVIE_ID_PARAMETER])

    init {
        loadData()
    }

    private fun loadData() {
        executeUseCase(
            useCase = getMovieDetailsUseCase,
            value = movieId,
            onResult = { updateViewState(Loaded(movieDetailsMapper.toPresentation(it))) },
            onException = { notify(exceptionMapper.toPresentation(it)) }
        )
    }

    fun onNavigateBackSelected() {
        navigate(Back)
    }

    fun onPlayMovieSelected(movieId: String) {
        navigate(PlayMovie(movieId))
    }
}
