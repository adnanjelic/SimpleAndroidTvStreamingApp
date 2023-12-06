package com.adnanjelic.simpletvstreamingapp.architecture.domain

import com.adnanjelic.simpletvstreamingapp.architecture.domain.exception.DomainException
import com.adnanjelic.simpletvstreamingapp.architecture.domain.exception.UnknownDomainException
import com.adnanjelic.simpletvstreamingapp.architecture.domain.usecase.UseCase
import kotlinx.coroutines.CancellationException

class UseCaseExecutor {

    suspend fun <OUTPUT> execute(
        useCase: UseCase<Unit, OUTPUT>,
        onResult: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) = execute(useCase, Unit, onResult, onException)

    suspend fun <INPUT, OUTPUT> execute(
        useCase: UseCase<INPUT, OUTPUT>,
        value: INPUT,
        onResult: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        try {
            useCase.execute(value, onResult)
        } catch (ignore: CancellationException) {
        } catch (throwable: Throwable) {
            onException(
                (throwable as? DomainException) ?: UnknownDomainException(throwable)
            )
        }
    }
}
