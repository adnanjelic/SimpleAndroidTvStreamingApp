package com.adnanjelic.simpletvstreamingapp.architecture.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class RunOnceUseCase<REQUEST, RESULT> : UseCase<REQUEST, RESULT> {

    final override suspend fun execute(
        input: REQUEST,
        onResult: (RESULT) -> Unit
    ) {
        val result = withContext(Dispatchers.IO) {
            executeInBackground(input)
        }
        withContext(Dispatchers.Main) {
            onResult(result)
        }
    }

    abstract suspend fun executeInBackground(request: REQUEST): RESULT
}
