package com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.domain.exception.DomainException
import com.adnanjelic.simpletvstreamingapp.architecture.domain.exception.UnknownDomainException
import com.adnanjelic.simpletvstreamingapp.architecture.presentation.mapper.DomainExceptionToPresentationNotificationMapper
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerPresentationNotification
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerPresentationNotification.UnknownError
import javax.inject.Inject

class VideoPlayerDomainToPresentationExceptionMapper @Inject constructor() :
    DomainExceptionToPresentationNotificationMapper<DomainException, VideoPlayerPresentationNotification> {

    override fun toPresentation(input: DomainException) = when (input) {
        is UnknownDomainException -> UnknownError(input)
        else -> UnknownError(input)
    }
}
