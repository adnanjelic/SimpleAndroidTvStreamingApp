package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.model

import com.adnanjelic.simpletvstreamingapp.architecture.ui.model.UiNotification

sealed class MovieDetailsUiNotification(open val message: String) : UiNotification {

    data class ErrorMessage(override val message: String) : MovieDetailsUiNotification(message)
}
