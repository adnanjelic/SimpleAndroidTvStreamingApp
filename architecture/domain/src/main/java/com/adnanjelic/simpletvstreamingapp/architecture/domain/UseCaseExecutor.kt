package com.adnanjelic.simpletvstreamingapp.architecture.domain

import com.adnanjelic.simpletvstreamingapp.architecture.domain.exception.DomainException
import com.adnanjelic.simpletvstreamingapp.architecture.domain.exception.UnknownDomainException
import com.adnanjelic.simpletvstreamingapp.architecture.domain.usecase.UseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UseCaseExecutor(
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) {
    fun <OUTPUT> execute(
        useCase: UseCase<Unit, OUTPUT>,
        onResult: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) = execute(useCase, Unit, onResult, onException)

    fun <INPUT, OUTPUT> execute(
        useCase: UseCase<INPUT, OUTPUT>,
        value: INPUT,
        onResult: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        coroutineScope.launch {
            try {
                useCase.execute(value, onResult)
            } catch (ignore: CancellationException) {
            } catch (@Suppress("TooGenericExceptionCaught") throwable: Throwable) {
                onException(
                    (throwable as? DomainException) ?: UnknownDomainException(throwable)
                )
            }
        }
    }
}
