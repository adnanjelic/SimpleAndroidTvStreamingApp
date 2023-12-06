package com.adnanjelic.simpletvstreamingapp.moviedetails.domain.usecase

import com.adnanjelic.simpletvstreamingapp.architecture.domain.usecase.RunOnceUseCase
import com.adnanjelic.simpletvstreamingapp.moviedetails.domain.model.MovieDetailsDomainModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repository: MovieDetailsRepository) :
    RunOnceUseCase<String, MovieDetailsDomainModel>() {

    override suspend fun executeInBackground(request: String) = repository.movieDetails(request)
}
