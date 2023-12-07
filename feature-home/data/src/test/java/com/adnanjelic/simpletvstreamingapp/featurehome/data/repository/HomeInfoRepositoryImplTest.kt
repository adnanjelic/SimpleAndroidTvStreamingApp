package com.adnanjelic.simpletvstreamingapp.featurehome.data.repository

import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoLocalSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoRemoteSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.mapper.HomeInfoDataToDomainMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.HomeInfoDataModel
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.model.HomeInfoDomainModel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import javax.crypto.IllegalBlockSizeException

class HomeInfoRepositoryImplTest {

    private val localSource: HomeInfoLocalSource = mock()
    private val remoteSource: HomeInfoRemoteSource = mock()
    private val modelMapper: HomeInfoDataToDomainMapper = mock()
    private val repository = HomeInfoRepositoryImpl(localSource, remoteSource, modelMapper)

    @Test
    fun `info Given the data is cached Then returns the data from local source`() = runBlocking {
        val cachedInfoDataModel: HomeInfoDataModel = mock()
        val expectedResult: HomeInfoDomainModel = mock()
        ArrangeBuilder()
            .withLocalSource(cachedInfoDataModel)
            .withModelMapper(cachedInfoDataModel, expectedResult)

        val actualResult = repository.info().toList()

        assertTrue(actualResult.size == 1)
        assertEquals(expectedResult, actualResult[0])
    }

    @Test
    fun `info Given the data is not cached Then returns the data from remote source and saves to local`() =
        runBlocking {
            val remoteInfoDataModel: HomeInfoDataModel = mock()
            val expectedResult: HomeInfoDomainModel = mock()
            ArrangeBuilder()
                .withLocalSource(null)
                .withRemoteSource(remoteInfoDataModel)
                .withModelMapper(remoteInfoDataModel, expectedResult)

            val actualResult = repository.info().toList()

            assertTrue(actualResult.size == 1)
            assertEquals(expectedResult, actualResult[0])
            verify(localSource).saveHomeInfo(remoteInfoDataModel)
        }

    @Test
    fun `info Given local source emits multiple values Then returns only one`() = runBlocking {
        val cachedInfoDataModel: HomeInfoDataModel = mock()
        val expectedResult: HomeInfoDomainModel = mock()
        ArrangeBuilder()
            .withLocalSource(cachedInfoDataModel, cachedInfoDataModel, cachedInfoDataModel)
            .withModelMapper(cachedInfoDataModel, expectedResult)

        val actualResult = repository.info().toList()

        assertTrue(actualResult.size == 1)
        assertEquals(expectedResult, actualResult[0])
    }

    @Test(expected = IllegalBlockSizeException::class)
    fun `info Given local source throws error Then it is propagated`(): Unit = runBlocking {
        val throwable = IllegalBlockSizeException()
        whenever(localSource.homeInfo()).then { throw throwable }

        repository.info()
    }

    private inner class ArrangeBuilder {

        suspend fun withLocalSource(vararg expectedResult: HomeInfoDataModel?) = apply {
            whenever(localSource.homeInfo()).thenReturn(flowOf(*expectedResult))
        }

        suspend fun withRemoteSource(expectedResult: HomeInfoDataModel) = apply {
            whenever(remoteSource.homeInfo()).thenReturn(expectedResult)
        }

        fun withModelMapper(input: HomeInfoDataModel, output: HomeInfoDomainModel) = apply {
            whenever(modelMapper.toDomain(input)).thenReturn(output)
        }
    }
}
