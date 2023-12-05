package com.adnanjelic.simpletvstreamingapp.moviedetails.presentation

import com.adnanjelic.simpletvstreamingapp.architecture.domain.UseCaseExecutor
import com.adnanjelic.simpletvstreamingapp.architecture.presentation.viewmodel.BaseViewModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.mapper.MovieDetailsDomainToPresentationExceptionMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationDestination
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationDestination.Back
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationDestination.PlayMovie
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationNotification
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
//    private val getHomeInfoUseCase: GetHomeInfoUseCase,
//    private val homeInfoMapper: HomeInfoDomainToPresentationModelMapper,
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
//        executeUseCase(
//            useCase = getHomeInfoUseCase,
//            onResult = { updateViewState(MovieDetailsViewState.Loaded(homeInfoMapper.toPresentation(it))) },
//            onException = { notify(exceptionMapper.toPresentation(it)) }
//        )

        val movie = MovieDetailsPresentationModel(
            id = "281",
            title = "Mission: Impossible - Dead Reckoning Part One",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            posterUrl = "https://www.closeup-shop.com/media/oart_0/oart_m/oart_14146/1023019_G524780.JPG",
            duration = "1:55:33",
            rating = 9.11f
        )
        updateViewState(MovieDetailsViewState.Loaded(movie))
    }

    fun onNavigateBackSelected() {
        navigate(Back)
    }

    fun onPlayMovieSelected(movieId: String) {
        navigate(PlayMovie(movieId))
    }
}
