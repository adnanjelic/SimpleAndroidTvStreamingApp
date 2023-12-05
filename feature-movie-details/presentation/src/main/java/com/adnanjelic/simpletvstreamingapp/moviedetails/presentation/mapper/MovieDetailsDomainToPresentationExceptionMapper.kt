package com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.domain.exception.DomainException
import com.adnanjelic.simpletvstreamingapp.architecture.domain.exception.UnknownDomainException
import com.adnanjelic.simpletvstreamingapp.architecture.presentation.mapper.DomainExceptionToPresentationNotificationMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationNotification
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationNotification.UnknownError
import javax.inject.Inject

class MovieDetailsDomainToPresentationExceptionMapper @Inject constructor() :
    DomainExceptionToPresentationNotificationMapper<DomainException, MovieDetailsPresentationNotification> {

    override fun toPresentation(input: DomainException) = when (input) {
        is UnknownDomainException -> UnknownError(input)
        else -> UnknownError(input)
    }
}
