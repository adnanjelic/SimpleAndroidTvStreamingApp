package com.adnanjelic.simpletvstreamingapp.architecture.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adnanjelic.simpletvstreamingapp.architecture.domain.UseCaseExecutor
import com.adnanjelic.simpletvstreamingapp.architecture.domain.exception.DomainException
import com.adnanjelic.simpletvstreamingapp.architecture.domain.usecase.UseCase
import com.adnanjelic.simpletvstreamingapp.architecture.presentation.navigation.PresentationDestination
import com.adnanjelic.simpletvstreamingapp.architecture.presentation.notification.PresentationNotification
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<VIEW_STATE : Any, NOTIFICATION : PresentationNotification, NAVIGATION_DESTINATION : PresentationDestination>(
    private val useCaseExecutor: UseCaseExecutor
) : ViewModel() {

    protected abstract val initialViewState: VIEW_STATE

    private val _viewState by lazy { MutableStateFlow(initialViewState) }
    val viewState = _viewState.asStateFlow()

    private val _notification by lazy { MutableSharedFlow<NOTIFICATION>() }
    val notification = _notification.asSharedFlow()

    private val _navigationDestination by lazy { MutableSharedFlow<NAVIGATION_DESTINATION>() }
    val navigationDestination = _navigationDestination.asSharedFlow()

    protected fun updateViewState(newState: VIEW_STATE) {
        MainScope().launch {
            _viewState.emit(newState)
        }
    }

    protected fun notify(notification: NOTIFICATION) {
        MainScope().launch {
            _notification.emit(notification)
        }
    }

    protected fun navigate(destination: NAVIGATION_DESTINATION) {
        MainScope().launch {
            _navigationDestination.emit(destination)
        }
    }

    protected fun <OUTPUT> executeUseCase(
        useCase:
        UseCase<Unit, OUTPUT>,
        onResult: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        viewModelScope.launch {
            useCaseExecutor.execute(useCase, onResult, onException)
        }
    }

    protected fun <INPUT, OUTPUT> executeUseCase(
        useCase: UseCase<INPUT, OUTPUT>,
        value: INPUT,
        onResult: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        viewModelScope.launch {
            useCaseExecutor.execute(useCase, value, onResult, onException)
        }
    }
}
