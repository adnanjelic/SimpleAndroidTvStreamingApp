package com.adnanjelic.simpletvstreamingapp.featurehome.presentation

import androidx.lifecycle.viewModelScope
import com.adnanjelic.simpletvstreamingapp.architecture.domain.UseCaseExecutor
import com.adnanjelic.simpletvstreamingapp.architecture.presentation.viewmodel.BaseViewModel
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.usecase.GetHomeInfoUseCase
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.mapper.HomeDomainToPresentationExceptionMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.mapper.HomeInfoDomainToPresentationModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomePresentationDestination
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomePresentationDestination.MovieDetails
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomePresentationNotification
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeInfoUseCase: GetHomeInfoUseCase,
    private val homeInfoMapper: HomeInfoDomainToPresentationModelMapper,
    private val homeExceptionMapper: HomeDomainToPresentationExceptionMapper,
    useCaseExecutor: UseCaseExecutor
) : BaseViewModel<HomeViewState, HomePresentationNotification, HomePresentationDestination>(
    useCaseExecutor
) {
    override val initialViewState = HomeViewState.Empty

    init {
        updateViewState(HomeViewState.Loading)
        loadData()
        viewModelScope.launch {
            delay(5000)
            notify(HomePresentationNotification.UnknownError(Throwable()))
        }
    }

    private fun loadData() {
        executeUseCase(
            useCase = getHomeInfoUseCase,
            onResult = { updateViewState(HomeViewState.Loaded(homeInfoMapper.toPresentation(it))) },
            onException = { notify(homeExceptionMapper.toPresentation(it)) }
        )
    }

    fun onMovieSelected(movieId: String) {
        navigate(MovieDetails(movieId))
    }
}
