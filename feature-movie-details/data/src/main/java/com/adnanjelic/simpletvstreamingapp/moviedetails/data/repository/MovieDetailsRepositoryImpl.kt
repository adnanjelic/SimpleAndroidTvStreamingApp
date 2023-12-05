package com.adnanjelic.simpletvstreamingapp.moviedetails.data.repository

import com.adnanjelic.simpletvstreamingapp.moviedetails.data.datasource.MovieDetailsLocalSource
import com.adnanjelic.simpletvstreamingapp.moviedetails.data.mapper.MovieDetailsDataToDomainModelMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.domain.model.MovieDetailsDomainModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.domain.repository.MovieDetailsRepository

class MovieDetailsRepositoryImpl(
    private val localSource: MovieDetailsLocalSource,
    private val movieDetailsMapper: MovieDetailsDataToDomainModelMapper
) : MovieDetailsRepository {

    override suspend fun movieDetails(movieId: String): MovieDetailsDomainModel {
        val dataModel = localSource.movieDetails(movieId)
        return movieDetailsMapper.toDomain(dataModel)
    }
}
