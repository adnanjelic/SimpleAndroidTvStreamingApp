package com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.notification.PresentationNotification

sealed interface MovieDetailsPresentationNotification : PresentationNotification {

    data class UnknownError(val error: Throwable) : MovieDetailsPresentationNotification
}
