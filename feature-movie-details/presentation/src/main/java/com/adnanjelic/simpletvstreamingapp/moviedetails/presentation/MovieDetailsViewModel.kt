package com.adnanjelic.simpletvstreamingapp.moviedetails.presentation

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
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val movieDetailsMapper: MovieDetailsDomainToPresentationModelMapper,
    private val exceptionMapper: MovieDetailsDomainToPresentationExceptionMapper,
    useCaseExecutor: UseCaseExecutor
) : BaseViewModel<MovieDetailsViewState, MovieDetailsPresentationNotification, MovieDetailsPresentationDestination>(
    useCaseExecutor
) {
    override val initialViewState = MovieDetailsViewState.Initial

    init {
        loadData()
    }

    private fun loadData() {
        executeUseCase(
            useCase = getMovieDetailsUseCase,
            value = "281",
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
