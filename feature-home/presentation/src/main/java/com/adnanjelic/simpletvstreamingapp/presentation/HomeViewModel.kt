package com.adnanjelic.simpletvstreamingapp.presentation

import com.adnanjelic.simpletvstreamingapp.architecture.domain.UseCaseExecutor
import com.adnanjelic.simpletvstreamingapp.architecture.presentation.viewmodel.BaseViewModel
import com.adnanjelic.simpletvstreamingapp.presentation.model.HomePresentationDestination
import com.adnanjelic.simpletvstreamingapp.presentation.model.HomePresentationNotification
import com.adnanjelic.simpletvstreamingapp.presentation.model.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    useCaseExecutor: UseCaseExecutor
) : BaseViewModel<HomeViewState, HomePresentationNotification, HomePresentationDestination>(
    useCaseExecutor
) {
    override val initialViewState = HomeViewState.Initial
}
