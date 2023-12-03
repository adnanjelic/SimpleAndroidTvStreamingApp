package com.adnanjelic.simpletvstreamingapp.presentation.model

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.notification.PresentationNotification

internal sealed interface HomePresentationNotification : PresentationNotification {

    data class UnknownError(val error: Throwable) : HomePresentationNotification
}
