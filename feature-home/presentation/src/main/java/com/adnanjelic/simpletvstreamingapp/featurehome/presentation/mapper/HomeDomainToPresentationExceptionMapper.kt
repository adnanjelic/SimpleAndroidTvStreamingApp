package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.domain.exception.DomainException
import com.adnanjelic.simpletvstreamingapp.architecture.domain.exception.UnknownDomainException
import com.adnanjelic.simpletvstreamingapp.architecture.presentation.mapper.DomainExceptionToPresentationNotificationMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomePresentationNotification
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomePresentationNotification.UnknownError
import javax.inject.Inject

class HomeDomainToPresentationExceptionMapper @Inject constructor() :
    DomainExceptionToPresentationNotificationMapper<DomainException, HomePresentationNotification> {

    override fun toPresentation(input: DomainException) = when (input) {
        is UnknownDomainException -> UnknownError(input)
        else -> UnknownError(input)
    }
}
