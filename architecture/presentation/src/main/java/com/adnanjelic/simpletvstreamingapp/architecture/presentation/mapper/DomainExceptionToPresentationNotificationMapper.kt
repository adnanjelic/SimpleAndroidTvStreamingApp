package com.adnanjelic.simpletvstreamingapp.architecture.presentation.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.domain.exception.DomainException
import com.adnanjelic.simpletvstreamingapp.architecture.presentation.model.PresentationNotification

interface DomainExceptionToPresentationNotificationMapper<INPUT : DomainException, OUTPUT : PresentationNotification> {

    fun toPresentation(input: INPUT): OUTPUT
}
