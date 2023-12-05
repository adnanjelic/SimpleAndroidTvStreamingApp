package com.adnanjelic.simpletvstreamingapp.moviedetails.domain.repository

import com.adnanjelic.simpletvstreamingapp.moviedetails.domain.model.MovieDetailsDomainModel

interface MovieDetailsRepository {

    suspend fun movieDetails(movieId: String): MovieDetailsDomainModel
}
