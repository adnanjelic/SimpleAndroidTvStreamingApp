package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.mapper

import com.adnanjelic.simpletvstreamingapp.featurehome.domain.model.MovieDomainModel
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.MoviePresentationModel
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieDomainToPresentationModelMapperTest {

    private val mapper = MovieDomainToPresentationModelMapper()

    @Test
    fun `Given input Then returns properly mapped model`() {
        val input = MovieDomainModel(
            id = "123",
            title = "The Matrix",
            posterUrl = "https://duckduckgo.com/?q=adolescens"
        )

        val actualResult = mapper.toPresentation(input)

        val expectedOutput = MoviePresentationModel(
            id = "123",
            title = "The Matrix",
            posterUrl = "https://duckduckgo.com/?q=adolescens"
        )
        assertEquals(expectedOutput, actualResult)
    }
}
