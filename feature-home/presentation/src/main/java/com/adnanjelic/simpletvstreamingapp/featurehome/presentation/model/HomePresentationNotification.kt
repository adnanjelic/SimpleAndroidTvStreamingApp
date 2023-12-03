package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.notification.PresentationNotification

sealed interface HomePresentationNotification : PresentationNotification {

    data class UnknownError(val error: Throwable) : HomePresentationNotification
}
