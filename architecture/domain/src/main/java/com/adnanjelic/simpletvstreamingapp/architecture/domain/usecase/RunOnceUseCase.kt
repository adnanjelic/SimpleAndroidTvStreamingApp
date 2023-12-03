package com.adnanjelic.simpletvstreamingapp.architecture.domain.usecase

import com.adnanjelic.simpletvstreamingapp.architecture.domain.CoroutineContextProvider
import kotlinx.coroutines.withContext

abstract class RunOnceUseCase<REQUEST, RESULT>(
    private val coroutineContextProvider: CoroutineContextProvider
) : UseCase<REQUEST, RESULT> {

    final override suspend fun execute(
        input: REQUEST,
        onResult: (RESULT) -> Unit
    ) {
        val result = withContext(coroutineContextProvider.io) {
            executeInBackground(input)
        }
        withContext(coroutineContextProvider.main) {
            onResult(result)
        }
    }

    abstract suspend fun executeInBackground(request: REQUEST): RESULT
}
