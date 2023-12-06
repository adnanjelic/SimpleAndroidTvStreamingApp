package com.adnanjelic.simpletvstreamingapp.featurehome.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper.PresentationToUiNotificationMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomePresentationNotification
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomePresentationNotification.UnknownError
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.HomeNotification
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.HomeNotification.ErrorMessage
import javax.inject.Inject

internal class HomeNotificationPresentationToUiModelMapper @Inject constructor() :
    PresentationToUiNotificationMapper<HomePresentationNotification, HomeNotification> {

    override fun toUi(input: HomePresentationNotification): HomeNotification {
        return when(input) {
            is UnknownError -> ErrorMessage("Unknown error occurred, please try later") // TODO: Add string to resources
        }
    }
}
