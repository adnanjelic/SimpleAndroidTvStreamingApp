package com.adnanjelic.simpletvstreamingapp.featurehome.domain.usecase

import com.adnanjelic.simpletvstreamingapp.featurehome.domain.model.HomeInfoDomainModel
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.repository.HomeInfoRepository
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetHomeInfoUseCaseTest {

    private val homeInfoRepository: HomeInfoRepository = mock()
    private val useCase = GetHomeInfoUseCase(homeInfoRepository)

    @Test
    fun `Returns data from the repository`() = runBlocking {
        val homeInfo1: HomeInfoDomainModel = mock()
        val homeInfo2: HomeInfoDomainModel = mock()
        whenever(homeInfoRepository.info()).thenReturn(flowOf(homeInfo1, homeInfo2))

        val actualResult = useCase.executeInBackground(Unit).toList()

        assertEquals(homeInfo1, actualResult[0])
        assertEquals(homeInfo2, actualResult[1])
    }
}
