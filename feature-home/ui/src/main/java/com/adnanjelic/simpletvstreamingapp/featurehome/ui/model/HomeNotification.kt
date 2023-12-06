package com.adnanjelic.simpletvstreamingapp.featurehome.ui.model

import com.adnanjelic.simpletvstreamingapp.architecture.ui.model.UiNotification

sealed class HomeNotification(open val message: String) : UiNotification {

    data class ErrorMessage(override val message: String) : HomeNotification(message)
}
