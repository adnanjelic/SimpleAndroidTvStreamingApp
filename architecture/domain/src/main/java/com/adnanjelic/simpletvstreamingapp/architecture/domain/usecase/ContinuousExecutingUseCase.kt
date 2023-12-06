package com.adnanjelic.simpletvstreamingapp.architecture.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

abstract class ContinuousExecutingUseCase<REQUEST, RESULT> : UseCase<REQUEST, RESULT> {

    final override suspend fun execute(
        input: REQUEST,
        onResult: (RESULT) -> Unit
    ) {
        withContext(Dispatchers.IO) {
            executeInBackground(input).collect { result ->
                withContext(Dispatchers.Main) {
                    onResult(result)
                }
            }
        }
    }

    abstract suspend fun executeInBackground(request: REQUEST): Flow<RESULT>
}
